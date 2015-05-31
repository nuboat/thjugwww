package services

import define.JobLevel.JobLevel
import models.slick.Subscriber.Subscriber

/**
 *
 * Created by nuboat
 */
trait SubscriberService {

  def addSubscriber(email: String, fullname: String, mobile: String, jobLevel: JobLevel): Option[Subscriber]

}
