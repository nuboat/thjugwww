package intercept

import com.google.inject.AbstractModule
import com.google.inject.matcher.Matchers
import net.codingwell.scalaguice.ScalaModule
import services.ConfigService

/**
 *
 * Created by nuboat
 */
case class LoggingModule() extends AbstractModule with ScalaModule {

  protected def configure() {
    bindInterceptor[LoggingInterceptor](methodMatcher = annotatedWith[Logging])
  }

}
