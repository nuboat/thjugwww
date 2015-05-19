package services

import models._
import scala.slick.driver.H2Driver.simple._
import slick.driver.PostgresDriver
import DatabaseService._

object AccountService{

	val account: TableQuery[Accounts] = TableQuery[Accounts]

	def addAccount(name:String,email:String,mobile:String):Option[Account] = {
		db.withSession { implicit session =>
			//create database
			account.ddl.create
			
			// insert account instances
			account.map(a => (a.name, a.email,a.mobile)) += (name,email,mobile)
			Some(account.filter(_.email === email).first)
		}
	}

	//Using this form when use postgresql
	/*def addAccount(acc:AccountPOSTRequest) = {
	
		val db = Database.forURL("jdbc:postgresql://localhost/thjug?user=postgres&password=q1w2e3r4maniacgroup", driver = "org.postgresql.Driver")
		db.withSession { implicit session =>
	
			account.map(a => (a.name, a.email,a.mobile)) += (acc.name,acc.email,acc.mobile)
	
			println(account.list)
		}
	}*/
}