package services.slick

import javax.inject.{Inject, Singleton}

import models.slick.Account
import models.slick.Account._
import org.postgresql.util.PSQLException
import play.api.Logger
import services.AccountService

/**
 *
 * Created by Pongthep
 * Contribute by nuboat
 */
@Singleton
private class SlickAccountService @Inject()(db: DatabaseService) extends AccountService {

  def addAccount(name: String, email: String, mobile: String, joblevel: Int): Option[Account] = {
    db.getDatabaseDef.withSession { implicit session =>
      try {
        return insertAccount(name, email, mobile, joblevel)
      } catch {
        case e: PSQLException => Logger.error(e.getMessage, e)
      }
      return None
    }
  }

}
