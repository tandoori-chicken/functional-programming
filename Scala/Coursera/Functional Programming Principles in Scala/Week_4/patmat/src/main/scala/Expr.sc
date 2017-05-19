trait Expr {
  //  def numValue: Int
  //
  //  def leftOp: Expr
  //
  //  def rightOp: Expr
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
  }
}

case class Number(n: Int) extends Expr {}

case class Sum(e1: Expr, e2: Expr) extends Expr {}


Sum(Number(1), Number(4)).eval

def show(e: Expr): String = e match {
  case Number(n) => n.toString
  case Sum(l, r) => show(l) + " + " + show(r)
}

show(Sum(Number(1), Number(4)))