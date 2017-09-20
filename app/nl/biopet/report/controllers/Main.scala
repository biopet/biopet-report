package nl.biopet.report.controllers

import javax.inject.Inject

import nl.biopet.summary.Schema
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import slick.driver.JdbcProfile
import slick.jdbc.H2Profile.api._

import scala.concurrent.{ExecutionContext, Future}

class Main @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                     cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc)  with HasDatabaseConfigProvider[JdbcProfile] {
  def catchAll(path: String) = Action {
    NotFound(nl.biopet.report.views.html.notFound())
  }

  def index() = Action.async { implicit request =>
    db.run(Schema.projects.result)
      .map(p => Ok(nl.biopet.report.views.html.index(p)))
  }
}
