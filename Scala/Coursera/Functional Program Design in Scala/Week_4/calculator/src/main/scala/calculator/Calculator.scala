package calculator

sealed abstract class Expr

final case class Literal(v: Double) extends Expr

final case class Ref(name: String) extends Expr

final case class Plus(a: Expr, b: Expr) extends Expr

final case class Minus(a: Expr, b: Expr) extends Expr

final case class Times(a: Expr, b: Expr) extends Expr

final case class Divide(a: Expr, b: Expr) extends Expr

object Calculator {
  def computeValues(
                     namedExpressions: Map[String, Signal[Expr]]): Map[String, Signal[Double]] = {

    namedExpressions.map({case (str,expr) => (str,Signal(eval(expr(), namedExpressions,str)))})
  }


  def eval(expr: Expr, references: Map[String, Signal[Expr]],key:String): Double = {

    expr match {
      case Literal(v) => v
      case Ref(name) => {
        if (name == key)
          Double.NaN
        else {
        val referencedExpr = getReferenceExpr(name, references)
        eval(referencedExpr, references, key)
      }
      }
      case Plus(a, b) => eval(a, references,key) + eval(b, references,key)
      case Minus(a, b) => eval(a, references,key) - eval(b, references,key)
      case Times(a, b) => eval(a, references,key) * eval(b, references,key)
      case Divide(a, b) => {
        val bEval = eval(b, references,key)

        if (bEval == 0)
          Double.NaN
        else
          eval(a, references,key) / bEval
      }
    }
  }

  /** Get the Expr for a referenced variables.
    * If the variable is not known, returns a literal NaN.
    */
  private def getReferenceExpr(name: String,
                               references: Map[String, Signal[Expr]]) = {
    references.get(name).fold[Expr] {
      Literal(Double.NaN)
    } { exprSignal =>
      exprSignal()
    }
  }
}
