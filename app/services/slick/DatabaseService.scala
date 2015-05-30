package services.slick

import javax.inject.{Inject, Singleton}

import services.ConfigService

import scala.slick.jdbc.JdbcBackend
import scala.slick.jdbc.JdbcBackend.DatabaseDef

/**
 *
 * Create by Pongthep
 * Contribute by nuboat
 */
@Singleton
private class DatabaseService @Inject()(val config: ConfigService) {

  private val url = config.getString("db.default.url").getOrElse("")
  private val user = config.getString("db.default.user").getOrElse("")
  private val password = config.getString("db.default.password").getOrElse("")
  private val dbdriver = config.getString(" db.default.driver").getOrElse("")

  private val fullurl = s"${url}?user=${user}&password=${password}"

  val getDatabaseDef: DatabaseDef = JdbcBackend.Database.forURL(fullurl, driver = dbdriver )

}
