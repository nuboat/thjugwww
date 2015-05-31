import org.scalatest.{FlatSpec, Matchers}
import play.api.test.Helpers._
import play.api.test._

class ApplicationSpec extends FlatSpec with Matchers {

  "Application" should
    "render the index page" in new WithApplication {
    val home = route(FakeRequest(GET, "/")).get

    status(home) should be(OK)
  }
}
