package services

/**
 *
 * Created by nuboat
 */
trait ConfigService {

  def getString(key: String): Option[String]

}
