package models

import scala.slick.driver.H2Driver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

case class Account(id: Int, name: String, email: String,mobile: String){
	def this(name: String, email: String,mobile: String) = this(-1,name, email,mobile)
}

class Accounts(tag: Tag) extends Table[Account](tag, "account") {
  def id: Column[Int] = column[Int]("user_id", O.PrimaryKey, O.AutoInc)
  def name: Column[String] = column[String]("user_name")
  def email: Column[String] = column[String]("email")
  def mobile: Column[String] = column[String]("mobile")
  def * = (id, name, email,mobile) <> (Account.tupled, Account.unapply)
}