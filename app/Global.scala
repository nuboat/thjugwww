import com.google.inject.matcher.Matchers
import com.google.inject.{AbstractModule, Guice}
import intercept.{LoggingModule, Logging, LoggingInterceptor}
import net.codingwell.scalaguice.ScalaModule
import play.api.GlobalSettings
import services.play.PlayModule
import services.slick.SlickModule

/**
 *
 * Created by nuboat
 */
object Global extends GlobalSettings {

  val injector = Guice.createInjector(SlickModule(), LoggingModule(), PlayModule())

  override def getControllerInstance[A](c: Class[A]): A = injector.getInstance(c)

}
