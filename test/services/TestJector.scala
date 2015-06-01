package services

import com.google.inject.{AbstractModule, Guice}
import net.codingwell.scalaguice.ScalaModule
import services.play.PlayModule
import services.slick.SlickModule

/**
 * Created by nuboat
 */
object TestJector {

  def instance[T: Manifest] = injector.getInstance(cls[T])

  private val injector = Guice.createInjector(SlickModule(), PlayModule())

  private def cls[T: Manifest] = manifest[T].runtimeClass.asInstanceOf[Class[T]]

}
