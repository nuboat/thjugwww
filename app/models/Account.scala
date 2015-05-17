package models

import scala.slick.driver.H2Driver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

case class Account(tag: Tag) extends Table[(Int, String, String, String)](tag, "account") {

  def id: Column[Int] = column[Int]("user_id", O.PrimaryKey)
  def name: Column[String] = column[String]("user_name")
  def email: Column[String] = column[String]("email")
  def mobile: Column[String] = column[String]("mobile")
  
  def * : ProvenShape[(Int, String, String, String)] = (id, name, email, mobile)
}

case class AccountPOSTRequest(name:String,email:String,mobile:String)