package nl.biopet.report.controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}

class Sample @Inject()(cc: ControllerComponents)
    extends AbstractController(cc) {
  def single(sample: Int) = TODO // TODO

  def sampleList(projectId: Option[Int] = None, runId: Option[Int] = None) = TODO // TODO

}
