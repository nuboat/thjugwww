import com.google.inject.matcher.Matchers
import com.google.inject.{AbstractModule, Guice}
import intercept.{Logging, LoggingInterceptor}
import net.codingwell.scalaguice.ScalaModule
import play.api.GlobalSettings
import services.slick.SlickModule

/**
 *
 * Created by nuboat
 */
object Global extends GlobalSettings {

  val loggingModule = new AbstractModule with ScalaModule {
    protected def configure(): Unit = {
      bindInterceptor(Matchers.any(), Matchers.annotatedWith(classOf[Logging]), new LoggingInterceptor)
    }
  }

  val injector = Guice.createInjector(SlickModule(), loggingModule)

  override def getControllerInstance[A](c: Class[A]): A = injector.getInstance(c)

}
