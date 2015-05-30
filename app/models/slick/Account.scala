package models.slick

import scala.slick.driver.PostgresDriver.simple._

/**
 *
 * Created by Pongthep
 */
object Account {

  case class Account(id: Int, name: String, email: String, mobile: String, level: Int) {
    def this(name: String, email: String, mobile: String, level: Int) = this(-1, name, email, mobile, level)
  }

  val account: TableQuery[Accounts] = TableQuery[Accounts]

  class Accounts(tag: Tag) extends Table[Account](tag, "account") {
    def id: Column[Int] = column[Int]("userid", O.PrimaryKey, O.AutoInc)

    def name: Column[String] = column[String]("username")

    def email: Column[String] = column[String]("email")

    def mobile: Column[String] = column[String]("mobile")

    def level: Column[Int] = column[Int]("level")

    def * = (id, name, email, mobile, level) <> (Account.tupled, Account.unapply)
  }

  def insertAccount(name: String, email: String, mobile: String, level: Int)(implicit session: Session): Option[Account] = {
    account.map(a => (a.name, a.email, a.mobile, a.level)) += (name, email, mobile, level)
    Some(account.filter(_.email === email).first)
  }

}
