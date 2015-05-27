package services.slick

import javax.inject.{Inject, Singleton}

import models.slick.Account
import Account._
import org.postgresql.util.PSQLException
import play.api.Logger
import services.AccountService

/**
 *
 * Created by Pongthep
 * Contribute by nuboat
 */
@Singleton
class SlickAccountService @Inject()(db: DatabaseService) extends AccountService {

  def addAccount(name: String, email: String, mobile: String, level: Int): Option[Account] = {
    db.getDatabaseDef.withSession { implicit session =>
      try {
        return insertAccount(name, email, mobile, level)
      } catch {
        case e: PSQLException => Logger.warn(e.getMessage)
      }
      return None
    }
  }

}
