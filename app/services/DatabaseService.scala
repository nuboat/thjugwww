package services

import scala.slick.driver.H2Driver.simple._

object DatabaseService{
	val db = Database.forURL("jdbc:h2:mem:hello", driver = "org.h2.Driver")
	//val db = Database.forURL("jdbc:postgresql://localhost/thjug?user=postgres&password=q1w2e3r4maniacgroup", driver = "org.postgresql.Driver")
}