package services.slick

import javax.inject.{Inject, Singleton}

import models.slick.Subscriber._
import org.postgresql.util.PSQLException
import play.api.Logger
import services.SubscriberService

/**
 *
 * Created by Pongthep
 * Contribute by nuboat
 */
@Singleton
private class SlickSubscriberService @Inject()(db: DatabaseService) extends SubscriberService {

  def addSubscriber(name: String, email: String, mobile: String, joblevel: Int): Option[Subscriber] = {
    db.getDatabaseDef.withSession { implicit session =>
      try {
        return insertSubscriber(name, email, mobile, joblevel)
      } catch {
        case e: PSQLException => Logger.error(e.getMessage, e)
      }
      return None
    }
  }

}
