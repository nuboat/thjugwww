package services.slick

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import services.{SubscriberService, AccountService}

/**
 *
 * Created by nuboat
 */
case class SlickModule() extends AbstractModule with ScalaModule {

  protected def configure() {
    bind[AccountService].to[SlickAccountService]
    bind[SubscriberService].to[SlickSubscriberService]
  }

}
