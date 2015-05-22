import com.google.inject.{Guice, AbstractModule}
import com.google.inject.matcher.Matchers
import intercept.{LoggingInterceptor, Logging}
import net.codingwell.scalaguice.ScalaModule
import play.api.GlobalSettings

/**
 *
 * Created by nuboat
 */
object Global extends GlobalSettings {

  val applicationModule = new AbstractModule with ScalaModule {
    protected def configure() {
    }
  }

  val loggingModule = new AbstractModule with ScalaModule {
    protected def configure(): Unit = {
      bindInterceptor(Matchers.any(), Matchers.annotatedWith(classOf[Logging]), new LoggingInterceptor)
    }
  }

  val injector = Guice.createInjector(applicationModule, loggingModule)

  override def getControllerInstance[A](c: Class[A]): A = injector.getInstance(c)

}
