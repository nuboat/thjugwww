package services.slick

import javax.inject.{Inject, Singleton}

import define.JobLevel.JobLevel
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

  def addSubscriber(name: String, email: String, mobile: String, jobLevel: JobLevel): Option[Subscriber] = {
    db.getDatabaseDef.withSession { implicit session =>
      try {
        return insertSubscriber(name, email, mobile, jobLevel.id)
      } catch {
        case e: PSQLException => {
          if (e.getMessage.contains("subscriber_pk")) {
            Logger.warn(e.getMessage)
          } else {
            Logger.error(e.getMessage, e)
          }
        }
      }
      return None
    }
  }

}
