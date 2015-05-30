// scalastyle:off
package controllers

import play.api._
import play.api.mvc._
import play.api.db._
import play.api.Play.current

import scala.collection.mutable


/**
 *
 * Created by nuboat
 */
object Api extends Controller {

  def getAccount(id: String) = Action {
    val result = mutable.ListBuffer[String]()
    DB.withConnection { conn =>
      val stmt = conn.createStatement
      val rs = stmt.executeQuery(s"SELECT * FROM ACCOUNT WHERE USERID = ${id}")
      while (rs.next()) {
        result += rs.getString("username")
      }
    }
    Ok(s"""{"NAME":"${result(0)}"}""")
  }

  def echo(text: String) = Action {
    Ok(s"{{{{ $text }}}}")
  }

}

// scalastyle:off
