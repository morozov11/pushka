package pushka.json

import org.typelevel.jawn.Facade.SimpleFacade
import pushka.Ast

object PushkaFacade extends SimpleFacade[Ast] {
  
  def jarray(vs: List[Ast]): Ast = Ast.Arr(vs)

  def jobject(vs: Map[String, Ast]): Ast = Ast.Obj(vs)

  def jint(s: String): Ast = Ast.Num(s)

  def jfalse(): Ast = Ast.False

  def jnum(s: String): Ast = Ast.Num(s)

  def jnull(): Ast = Ast.Null

  def jtrue(): Ast = Ast.True

  def jstring(s: String): Ast = Ast.Str(s)

  override def jnum(s: CharSequence, decIndex: Int, expIndex: Int): Ast = Ast.Num(s.toString)

  override def jstring(s: CharSequence): Ast = Ast.Str(s.toString)
}
