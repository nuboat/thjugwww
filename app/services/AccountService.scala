package services

import models.slick.Account
import Account.Account

/**
 *
 * Created by nuboat
 */
trait AccountService {

  def addAccount(name: String, email: String, mobile: String, level: Int): Option[Account]

}
