package nl.biopet.report.controllers

import javax.inject.Inject

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

class Run @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                    cc: ControllerComponents)(implicit exec: ExecutionContext)
    extends AbstractController(cc)
    with HasDatabaseConfigProvider[JdbcProfile] {
  def single(runId: Int) = TODO //TODO
  def runList(projectId: Option[Int] = None) = TODO //TODO

}
