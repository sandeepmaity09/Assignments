package edu.knoldus.parsing

import scala.util.parsing.combinator.RegexParsers
import scala.util.parsing.input.CharSequenceReader

trait ArithmeticParser extends RegexParsers with Syntax {

  def integer:Parser[IntegerLiteral] = """([-?\d]+)""".r ^^ { case st => IntegerLiteral(st.toInt) }

  def sum:Parser[Sum] = operand ~ "+" ~ operand ^^ { case (num1~"+"~num2) => Sum(num1,num2) }

  def minus:Parser[Minus] = operand ~ "-" ~ operand ^^ { case (num1~"-"~num2) => Minus(num1,num2) }

  def product:Parser[Product] = operand ~ "*" ~ operand ^^ { case (num1~"*"~num2) => Product(num1,num2) }

  def divide:Parser[Divide] = operand ~ "/" ~ operand ^^ { case (num1~"/"~num2) => Divide(num1,num2) }

  def parenthesizedExpr = "(" ~ expression ~ ")" ^^ { case ("("~expr~")") => expr }

  def operand = (integer | parenthesizedExpr)

  def expression:Parser[Expression] = ( sum | minus | product | divide | integer | parenthesizedExpr )

}

object ArithmeticParser extends ArithmeticParser {

  def parseExpr(s: CharSequence): Expression = {
    parseExpr(new CharSequenceReader(s))
  }

  def parseExpr(input: CharSequenceReader): ArithmeticParser.Expression = {
    parsePhrase(input) match {
      case Success(t, _) => t
      case NoSuccess(msg, next) => throw new IllegalArgumentException(
        "Could not parse '" + input + "' near '" + next.pos.longString + ": " + msg)
    }
  }

  def parsePhrase(input: CharSequenceReader): ParseResult[Expression] = {
    phrase(expression)(input)
  }
}
