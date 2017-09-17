package nl.biopet.report.controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}

class Run @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def single(projectId: Int, runId: Int) = TODO //TODO
  def projectRuns(projectId: Int) = TODO //TODO
  def allRuns = TODO //TODO

}
