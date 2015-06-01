package services.slick

import define.JobLevel
import models.Subscriber
import org.scalatest.{FlatSpec, Matchers}
import play.api.test.WithApplication
import services.TestJector

/**
 * Created by nuboat
 */
class SlickSubscriberServiceSpec extends FlatSpec with Matchers {

  val id = System.currentTimeMillis()

  "SlickSubscriberService.addSubscriber with new email" should
    "result.isEmpty should be true" in new WithApplication {

    val service = TestJector.instance[SlickSubscriberService]
    val subscriber = Subscriber("nuboat", s"nb$id@thjug.com", "0000000000", JobLevel.CLevel.id)
    val result = service.addSubscriber(subscriber)
    result.isEmpty should be(false)
  }

  "SlickSubscriberService.addAsyncSubscriber with exist email" should
    "result.isEmpty should be false" in new WithApplication {

    val service = TestJector.instance[SlickSubscriberService]
    val subscriber = Subscriber("nuboat", s"nb-async$id@thjug.com", "0000000000", JobLevel.Technical.id)
    service.addAsyncSubscriber(subscriber)
  }

  "SlickSubscriberService.addSubscriber with exist email" should
    "result.isEmpty should be false" in new WithApplication {

    val service = TestJector.instance[SlickSubscriberService]
    val subscriber = Subscriber("nuboat", s"nb$id@thjug.com", "0000000000", JobLevel.CLevel.id)
    val result = service.addSubscriber(subscriber)
    result.isEmpty should be(true)
  }

  "SlickSubscriberService.groupJobLevel" should
    "joblevel, count(1) should not empty" in new WithApplication {

    val service = TestJector.instance[SlickSubscriberService]
    val groupJobLevel = service.groupJobLevel()
    groupJobLevel.isEmpty should be(false)
  }

}
