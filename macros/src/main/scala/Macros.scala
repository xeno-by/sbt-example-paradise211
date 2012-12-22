import language.experimental.macros
import scala.reflect.macros.Context

class C { def hello = println("hello world") }
object Macros {
  def impl(c: Context) = c.universe.Ident(c.universe.TypeName("C"))
  type TM = macro impl
}