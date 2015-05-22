package services

import javax.inject.{Inject, Singleton}

import models.Account._

@Singleton
class SlickAccountService @Inject() (db: DatabaseService) extends AccountService {

  def addAccount(name: String, email: String, mobile: String): Option[Account] = {
    db.getDatabaseDef.withSession { implicit session =>
      insertAccount(name, email, mobile)
    }
  }

}