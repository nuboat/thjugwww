package controllers

import javax.inject.{Inject, Singleton}
import play.api._
import play.api.mvc._
import services._
import models._
import play.api.data.Form
import play.api.data.Forms._

@Singleton
case class Application @Inject() () extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def example = Action {
    Ok(views.html.example())
  }

  val accountForm: Form[AccountPOSTRequest] = Form {
  	mapping(
      "contactName" -> text,
	  "email" -> text,
	  "mobileno" -> text
  	)(AccountPOSTRequest.apply)(AccountPOSTRequest.unapply)
  }

  def register = Action {implicit request =>
	accountForm.bindFromRequest.fold(
		formWithErrors => {
			println("Error")
			Ok(views.html.index("Your new application is ready."))
		},
		accountData => {
			AccountService.addAccount(accountData)
			Ok(views.html.index("Your new application is ready."))
		}
	)
  }
}