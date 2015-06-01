// scalastyle:off
package controllers

import javax.inject.{Inject, Singleton}

import models.Subscriber
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

  val hello = "Hello World!"
  def index = Action {
    val jobLevels = subscriberService.groupJobLevel()
    Ok(views.html.index(hello, jobLevels))
  }

  def example = Action {
    Ok(views.html.example())
  }

  def register = Action { implicit request =>
    val jobLevels = subscriberService.groupJobLevel()

    registerForm
      .bindFromRequest()(request)
      .fold(formWithErrors => Ok(views.html.index(hello, jobLevels)),
        subscriberData => {
          val subscriber = Subscriber(subscriberData._1, subscriberData._2, subscriberData._3, subscriberData._4.toInt)
          subscriberService.addSubscriber(subscriber) match {
            case None => {
              Logger.info(s"Subscriber ${subscriberData} cannot register")
              Ok(views.html.index(hello, jobLevels))
            }
            case subscriber => {
              Logger.info(s"Subscriber ${subscriberData} registerd")
              Ok(views.html.index(hello, jobLevels))
            }
          }
        }
      )
  }
}

// scalastyle:off
