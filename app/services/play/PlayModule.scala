package services.play

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import services.{ConfigService, AccountService}

/**
 * Created by nuboat
 */
case class PlayModule() extends AbstractModule with ScalaModule {

  protected def configure() {
    bind[ConfigService].to[PlayService]
  }

}
