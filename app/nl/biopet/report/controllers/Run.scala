package nl.biopet.report.controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}

class Run @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def single(runId: Int) = TODO //TODO
  def runList(projectId: Option[Int] = None) = TODO //TODO

}
