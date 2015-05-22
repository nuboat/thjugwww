// scalastyle:off
package controllers

import javax.inject.{Inject, Singleton}

import play.api._
import play.api.mvc._

@Singleton
case class Application @Inject()() extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def example = Action {
    Ok(views.html.example())
  }

  def register = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
// scalastyle:off
