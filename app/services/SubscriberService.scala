package services

import define.JobLevel.JobLevel
import models.Subscriber

/**
 *
 * Created by nuboat
 */
trait SubscriberService {

  def addSubscriber(subscriber: Subscriber): Option[Subscriber]

}
