package services.slick

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import services.SubscriberService

/**
 *
 * Created by nuboat
 */
case class SlickModule() extends AbstractModule with ScalaModule {

  protected def configure() {
    bind[SubscriberService].to[SlickSubscriberService]
  }

}
