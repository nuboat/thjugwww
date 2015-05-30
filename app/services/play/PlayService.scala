package services.play

import javax.inject.Singleton

import play.api.Configuration
import play.api.Play.current
import services.ConfigService


/**
 * Created by nuboat
 */
@Singleton
private class PlayService extends ConfigService {

  private lazy val c: Configuration = current.configuration

  def getString(key: String): Option[String] = {
    return c.getString(key)
  }

}
