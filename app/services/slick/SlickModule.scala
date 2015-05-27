package services.slick

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import services.AccountService

/**
 * Created by nuboat
 */
case class SlickModule() extends AbstractModule with ScalaModule {

  protected def configure() {
    bind[AccountService].to[SlickAccountService]
  }

}
