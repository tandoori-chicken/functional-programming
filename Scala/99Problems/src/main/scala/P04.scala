import scala.annotation.tailrec

/**
  * Created by adarsh on 03/07/2017.
  */
object P04 {
  def length[T](xs: List[T]): Int = {

    @tailrec
    def _length(xs1: List[T], accumulator: Int): Int = xs1 match {
      case Nil => accumulator
      case _ => _length(xs1.tail, accumulator + 1)
    }

    _length(xs, 0)
  }

}
