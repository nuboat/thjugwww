package services.slick

import org.scalatest.{FlatSpec, Matchers}
import play.api.test.WithApplication
import services.TestJector

/**
 * Created by nuboat
 */
class SlickAccountServiceSpec extends FlatSpec with Matchers {

  val userid = System.currentTimeMillis()

  "SlickAccountService.addAccount with new userid" should
    "insert with no exception and result is not empty" in new WithApplication {

    val service = TestJector.instance[SlickAccountService]
    val result = service.addAccount(userid.toString, "nuboat", "nb@thjug.com", 1)
    result.isEmpty should be(false)
  }

  "SlickAccountService.addAccount with new userid" should
    "cannot insert and result is empty" in new WithApplication {

    val service = TestJector.instance[SlickAccountService]
    val result = service.addAccount(userid.toString, "nuboat", "nb@thjug.com", 1)
    result.isEmpty should be(true)
  }

}
