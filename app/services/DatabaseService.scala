package services

import scala.slick.driver.H2Driver.simple._

object DatabaseService{
	val db = Database.forURL("jdbc:h2:mem:hello", driver = "org.h2.Driver")
}