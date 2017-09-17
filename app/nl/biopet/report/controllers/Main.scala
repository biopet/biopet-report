package nl.biopet.report.controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}

class Main @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def catchAll(path: String) = Action {
    NotFound(nl.biopet.report.views.html.notFound())
  }
}
