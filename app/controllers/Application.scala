package controllers

import javax.inject.{Inject, Singleton}
import play.api._
import play.api.mvc._
import services._
import models._
import play.api.data.Form
import play.api.data.Forms._
import views.RequestForms.Pattern._

@Singleton
case class Application @Inject() () extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def example = Action {
    Ok(views.html.example())
  }

  def register = Action {implicit request =>
	registerForm.bindFromRequest()(request).fold(
		formWithErrors => {
			println("Error:"+formWithErrors)
			Ok(views.html.index("Your new application is ready."))
		},
		accountData => {
			AccountService.addAccount(accountData._1,accountData._2,accountData._3) match{
				case None => {
					println("Can not register")
					Ok(views.html.index("Your new application is ready."))
				}
				case account => {
					println("Account added")
					Ok(views.html.index("Your new application is ready."))
				}
			}
		}
	)
  }
}