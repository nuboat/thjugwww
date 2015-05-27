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
case class Application @Inject()(accountService: AccountService) extends Controller {

  def index = Action {
    Ok(views.html.index(""))
  }

  def example = Action {
    Ok(views.html.example())
  }

  def register = Action { implicit request =>
    registerForm.bindFromRequest()(request).fold(
      formWithErrors => {
        println("Error:" + formWithErrors)
        Ok(views.html.index(""))
      },
      accountData => {
        accountService.addAccount(accountData._1, accountData._2, accountData._3, accountData._4.toInt) match {
          case None => {
            Logger.info(s"Account ${accountData} cannot register")
            Ok(views.html.index(""))
          }
          case account => {
            Logger.info(s"Account ${accountData} registerd")
            Ok(views.html.index(""))
          }
        }
      }
    )
  }
}

// scalastyle:off
