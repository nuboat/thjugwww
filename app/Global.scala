import com.google.inject.AbstractModule
import controllers.PlayJector
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

  PlayJector.initial(applicationModule)

  override def getControllerInstance[A](c: Class[A]): A = PlayJector.instance(c)

}
