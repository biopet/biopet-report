package nl.biopet.report.controllers

import javax.inject.Inject

import nl.biopet.summary.SummaryDbWrite
import nl.biopet.summary.Schema
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.{AbstractController, ControllerComponents}
import slick.jdbc.JdbcProfile
import slick.jdbc.H2Profile.api._

import scala.concurrent.{ExecutionContext, Future}

class Sample @Inject()(protected val dbConfigProvider: DatabaseConfigProvider,
                       cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc)
  with HasDatabaseConfigProvider[JdbcProfile] {

  lazy val summary = new SummaryDbWrite(db)

  def single(sample: Int) = TODO // TODO

  def sampleList(projectId: Option[Int] = None, runId: Option[Int] = None) = Action.async { implicit request =>
    var q = for {
      sample <- Schema.samples
      run <- Schema.runs if sample.runId === run.id
      project <- Schema.projects if run.projectId === project.id
    } yield (sample, run, project)
    runId.foreach(id => q = q.filter(_._1.runId === id))
    projectId.foreach(id => q = q.filter(_._2.projectId === id))
    db.run(q.result).map(s => Ok(nl.biopet.report.views.html.sampleList(s)))
  }
}
