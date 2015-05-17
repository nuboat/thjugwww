package services

import models._
import scala.slick.driver.H2Driver.simple._
import slick.driver.PostgresDriver

object AccountService{

	val account: TableQuery[Account] = TableQuery[Account]

	def addAccount(acc:AccountPOST) = {
	
		val db = Database.forURL("jdbc:h2:mem:hello", driver = "org.h2.Driver")
		db.withSession { implicit session =>
			//create database
			account.ddl.create
			
			// insert account instances
			account += (account.list.length+1,acc.name,acc.email,acc.mobile)
			println(account.list)
		}
	}
	
	//Using this form when use postgresql
	/*def addAccount(acc:AccountPOST) = {
	
		val db = Database.forURL("jdbc:postgresql://localhost/thjug?user=postgres&password=q1w2e3r4maniacgroup", driver = "org.postgresql.Driver")
		db.withSession { implicit session =>
			account += (account.list.length+1,acc.name,acc.email,acc.mobile)
			println(account.list)
		}
	}*/
}