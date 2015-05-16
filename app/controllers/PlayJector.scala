package controllers

import com.google.inject.matcher.Matchers
import com.google.inject.{Guice, AbstractModule, Injector}
import intercept.{LoggingInterceptor, Logging}
import net.codingwell.scalaguice.ScalaModule

/**
 *
 * Created by nuboat
 */
object PlayJector {

  private var name:String = null
  private var injector:Injector = null

  val loggingModule = new AbstractModule  with ScalaModule {
    protected def configure(): Unit = {
      bindInterceptor(Matchers.any(), Matchers.annotatedWith(classOf[Logging]), new LoggingInterceptor)
    }
  }

  def initial(applicationModule: AbstractModule):Unit = {
    if (injector == null) {
      name = applicationModule.toString()
      injector = Guice.createInjector(applicationModule, loggingModule)
    }
  }

  def get: Injector =  {
    if (injector != null)
      return injector
    else
      throw new IllegalStateException("Please initiate PlayJector by PlayJector.initial(module)")
  }

  private def cls[T: Manifest] = manifest[T].runtimeClass.asInstanceOf[Class[T]]

  def instance[T: Manifest] = get.getInstance(cls[T])

  def instance[T](c: Class[T]): T = get.getInstance(c)

}
