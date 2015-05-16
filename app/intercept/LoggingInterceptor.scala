package intercept

import java.util.concurrent.TimeUnit

import com.google.common.base.Stopwatch
import org.aopalliance.intercept.{MethodInterceptor, MethodInvocation}
import play.api.Logger


/**
 *
 * Created by nuboat
 */
class LoggingInterceptor extends MethodInterceptor {

  val log = Logger("metrix")

  def invoke(invocation: MethodInvocation): AnyRef = {
    val watch = Stopwatch.createStarted()
    val className = invocation.getMethod.getDeclaringClass.getSimpleName
    val methodName = invocation.getMethod.getName

    try {
      invocation.proceed()
    } catch {
      case t: Throwable => {
        log.error(t.getMessage)
        throw t
      }
    } finally {
      val elapsed = watch.stop.elapsed(TimeUnit.MILLISECONDS)
      log.info(s"""${className}.${methodName}, Execution in ${elapsed} ms.""")
    }
  }
}
