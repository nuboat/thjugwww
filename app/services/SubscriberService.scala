package services

import models.slick.Account
import models.slick.Account.Account
import models.slick.Subscriber.Subscriber

/**
 *
 * Created by nuboat
 */
trait SubscriberService {

  def addSubscriber(email: String, fullname: String, mobile: String, level: Int): Option[Subscriber]

}
