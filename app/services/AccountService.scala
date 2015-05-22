package services

import models.Account.Account

/**
 *
 * Created by nuboat
 */
trait AccountService {

  def addAccount(name: String, email: String, mobile: String): Option[Account]

}
