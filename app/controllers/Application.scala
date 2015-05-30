// scalastyle:off
package controllers

import javax.inject.{Inject, Singleton}

import play.api._
import play.api.mvc._
import services._
import views.RequestForms.Pattern._

/**
 *
 * Created by nuboat
 * Contribute by Pongthep
 */
@Singleton
case class Application @Inject()(subscriberService: SubscriberService) extends Controller {

  def index = Action {
    Ok(views.html.index(""))
  }

  def example = Action {
    Ok(views.html.example())
  }

  def register = Action { implicit request =>
    registerForm
      .bindFromRequest()(request)
      .fold(formWithErrors => Ok(views.html.index("")),
        subscriberData => {
          subscriberService.addSubscriber(subscriberData._1, subscriberData._2, subscriberData._3, subscriberData._4.toInt) match {
            case None => {
              Logger.info(s"Subscriber ${subscriberData} cannot register")
              Ok(views.html.index(""))
            }
            case account => {
              Logger.info(s"Subscriber ${subscriberData} registerd")
              Ok(views.html.index(""))
            }
          }
        }
      )
  }
}

// scalastyle:off
