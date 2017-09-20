package nl.biopet.report.controllers

import javax.inject.Inject

import nl.biopet.summary.SummaryDbWrite
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

class Project @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                     cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc)
  with HasDatabaseConfigProvider[JdbcProfile] {

  lazy val summary = new SummaryDbWrite(db)

  def single(projectId: Int) = Action.async { implicit request =>
    val project = summary.getProject(projectId)
    val runs = summary.getRuns(protectId = Some(projectId))
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
    summary.getProjects()
      .map(p => Ok(nl.biopet.report.views.html.projectList(p)))
  }

}
