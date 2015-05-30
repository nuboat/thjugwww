package services.slick

import org.scalatest.{FlatSpec, Matchers}
import play.api.test.WithApplication
import services.TestJector

/**
 * Created by nuboat
 */
class SlickSubscriberServiceSpec extends FlatSpec with Matchers {

  val id = System.currentTimeMillis()

  "SlickSubscriberService.addSubscriber with new email" should
    "insert with no exception and result is not empty" in new WithApplication {

    val service = TestJector.instance[SlickSubscriberService]
    val result = service.addSubscriber("nuboat", s"nb$id@thjug.com", "0894446110", 1)
    result.isEmpty should be(false)
  }

  "SlickSubscriberService.addSubscriber with exist email" should
    "cannot insert and result is empty" in new WithApplication {

    val service = TestJector.instance[SlickSubscriberService]
    val result = service.addSubscriber("nuboat", s"nb$id@thjug.com", "0894446110", 1)
    result.isEmpty should be(true)
  }

}
