package services

import models.{GroupJobLevel, Subscriber}

/**
 *
 * Created by nuboat
 */
trait SubscriberService {

  def groupJobLevel(): List[GroupJobLevel]

  def addAsyncSubscriber(subscriber: Subscriber)

  def addSubscriber(subscriber: Subscriber): Option[Subscriber]

}
