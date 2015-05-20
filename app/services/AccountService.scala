package services

import models.Account._
import scala.slick.driver.H2Driver.simple._
import slick.driver.PostgresDriver
import DatabaseService._

object AccountService{

	def addAccount(name:String,email:String,mobile:String):Option[Account] = {
		db.withSession { implicit session =>
			insertAccount(name,email,mobile)
		}
	}

	//Using this form when use postgresql
	/*def addAccount(name:String,email:String,mobile:String):Option[Account] = {
		db.withSession { implicit session =>
			insertAccount(name,email,mobile)
		}
	}*/
}