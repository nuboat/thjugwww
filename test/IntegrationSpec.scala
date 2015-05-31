import org.scalatest.{FlatSpec, Matchers}
import play.api.test._

class IntegrationSpec extends FlatSpec with Matchers {

  "Application" should
    "work from within a browser" in new WithBrowser {

    browser.goTo("http://localhost:" + port)
    //browser.pageSource must contain("Thailand JVM user group")
  }

}
