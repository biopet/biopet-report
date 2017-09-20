package nl.biopet.report.controllers

import javax.inject.Inject

import nl.biopet.summary.Schema
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import slick.driver.JdbcProfile
import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext

class Project @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                     cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc)  with HasDatabaseConfigProvider[JdbcProfile] {
  def single(projectId: Int) = Action.async { implicit request =>
    val project = db.run(Schema.projects.filter(_.id === projectId).result).map(_.headOption)
    val runs = db.run(Schema.runs.filter(_.projectId === projectId).result)
    for {
      p <- project
      r <- runs
    } yield {
      p match {
        case Some(pr) => Ok(nl.biopet.report.views.html.project(pr, r))
        case _ => NotFound(nl.biopet.report.views.html.notFound())
      }
    }
  }

  def all() = Action.async { implicit request =>
    db.run(Schema.projects.result)
      .map(p => Ok(nl.biopet.report.views.html.projectList(p)))
  }

}
