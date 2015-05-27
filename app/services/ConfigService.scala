package services

import javax.inject.Singleton

import play.api.Configuration
import play.api.Play.current


/**
 * Created by nuboat
 */
@Singleton
class ConfigService {

  private lazy val c: Configuration = current.configuration

  def getString(key: String): String = {
    return c.getString(key).getOrElse(null)
  }

}
