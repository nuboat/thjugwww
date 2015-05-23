package services

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.test.WithApplication

@RunWith(classOf[JUnitRunner])
class SlickAccountServiceSpec extends Specification {

  "addAccount" should {
    "insert with no exception" in {
      val service = PlayJector.instance[SlickAccountService]

      service.addAccount("a", "b", "00")
    }
  }
}
