package pushka.json

import org.typelevel.jawn.Parser
import pushka.Ast

final class JsonParser extends pushka.Parser[String] {
  def parse(data: String): Ast = {
    Parser.parseFromString(data)(PushkaFacade).get
  }
}
