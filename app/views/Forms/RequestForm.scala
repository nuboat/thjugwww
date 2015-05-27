package views.RequestForms

import play.api.data._
import play.api.data.Forms._

/**
 *
 * Contribute by Pongthep
 */
object Pattern {

  val registerMapping = Forms.tuple(
    "contactName" -> Forms.text,
    "email" -> Forms.text,
    "mobileno" -> Forms.text,
    "level" -> Forms.text)

  val registerForm = Form(registerMapping)

}
