package services

import javax.inject.Singleton


import scala.slick.jdbc.JdbcBackend
import scala.slick.jdbc.JdbcBackend.DatabaseDef

@Singleton
class DatabaseService {

  //val getDatabaseDef: DatabaseDef = Database.forURL("jdbc:h2:mem:hello", driver = "org.h2.Driver")

  val getDatabaseDef: DatabaseDef = JdbcBackend.Database.forURL("jdbc:postgresql://db.thjug.com/thjug?user=thjug&password=", driver = "org.postgresql.Driver")
}