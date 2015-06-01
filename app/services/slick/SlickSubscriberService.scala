// scalastyle:off
package services.slick

import javax.inject.Singleton

import define.JobLevel
import intercept.Logging
import models.{GroupJobLevel, Subscriber}
import org.postgresql.util.PSQLException
import play.api.Logger
import play.api.cache.Cache
import play.api.Play.current
import services.SubscriberService
import slick.driver.PostgresDriver.api._
import scala.collection.mutable
import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.Success


/**
 *
 * Created by Pongthep
 * Contribute by nuboat
 */
private class Subscribers(tag: Tag) extends Table[Subscriber](tag, "subscriber") {

  def email: Rep[String] = column[String]("email", O.PrimaryKey)

  def name: Rep[String] = column[String]("fullname")

  def mobile: Rep[String] = column[String]("mobile")

  def jobLevel: Rep[Int] = column[Int]("joblevel")

  def * = (name, email, mobile, jobLevel) <>(Subscriber.tupled, Subscriber.unapply)
}

@Singleton
private class SlickSubscriberService extends SubscriberService {

  val subscribers = TableQuery[Subscribers]

  @Logging
  def groupJobLevel(): List[GroupJobLevel] = {
    val cache = Cache.get("groupJobLevel")
    if (cache.isDefined) {
      return cache.asInstanceOf[List[GroupJobLevel]]
    }

    val db = Database.forConfig("db")
    try {
      val query = sql"""
              select  joblevel, count(1) as count
              from 	  subscriber
              group by  joblevel
              order by  joblevel;""".as[(Int, Int)]

      val buffer = mutable.ListBuffer[GroupJobLevel]()
      val f = db.run(query).map(x => x.foreach( t => buffer.append(GroupJobLevel(JobLevel(t._1), t._2))))
      Await.result(f, Duration.Inf)

      val result = buffer.toList
      Cache.set("groupJobLevel", result, 3600)
      return result
    } finally db.close
  }

  @Logging
  def addSubscriber(subscriber: Subscriber): Option[Subscriber] = {
    val db = Database.forConfig("db")
    val isCompleted = {
      val f = db.run((subscribers += subscriber).transactionally)
      try {
        Await.result(f, Duration.Inf)
        true
      } catch {
        case _: Throwable => false
      } finally db.close
    }
    return if (isCompleted) return Some(subscriber) else None
  }

  def addAsyncSubscriber(subscriber: Subscriber) = {
    val db = Database.forConfig("db")
    try {
      db.run((subscribers += subscriber).transactionally)
    } finally db.close
  }

}

// scalastyle:off
