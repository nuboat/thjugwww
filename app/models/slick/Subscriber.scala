package models.slick

import define.JobLevel.JobLevel

import scala.slick.driver.PostgresDriver.simple._

/**
 *
 * Created by nuboat
 */
object Subscriber {

  case class Subscriber(name: String, email: String, mobile: String, jobLevel: Int)

  val subscriber: TableQuery[Subscribers] = TableQuery[Subscribers]

  class Subscribers(tag: Tag) extends Table[Subscriber](tag, "subscriber") {
    def email: Column[String] = column[String]("email")

    def name: Column[String] = column[String]("fullname")

    def mobile: Column[String] = column[String]("mobile")

    def jobLevel: Column[Int] = column[Int]("joblevel")

    def * = (name, email, mobile, jobLevel) <>(Subscriber.tupled, Subscriber.unapply)
  }

  def insertSubscriber(name: String, email: String, mobile: String, jobLevel: Int)(implicit session: Session): Option[Subscriber] = {
    subscriber.map(a => (a.name, a.email, a.mobile, a.jobLevel)) +=(name, email, mobile, jobLevel)
    Some(subscriber.filter(_.email === email).first)
  }

}
