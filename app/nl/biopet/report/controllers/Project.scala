package nl.biopet.report.controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}

class Project @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def single(projectId: Int) = TODO //TODO
  def all = TODO //TODO

}
