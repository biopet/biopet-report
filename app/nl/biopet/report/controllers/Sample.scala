package nl.biopet.report.controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}

class Sample @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def singleName(projectId: Int, runId: Int, sampleName: String) = TODO // TODO
  def single(projectId: Int, runId: Int, sample: Int) = TODO // TODO

  def runSamples(projectId: Int, runId: Int) = TODO // TODO

  def projectSamples(projectId: Int) = TODO // TODO

  def allSamples = TODO // TODO

}
