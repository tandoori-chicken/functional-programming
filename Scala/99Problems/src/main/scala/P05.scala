import scala.annotation.tailrec

/**
  * Created by adarsh on 03/07/2017.
  */
object P05 {


  def reverse[T](xs: List[T]): List[T] = {

    @tailrec
    def _reverse(xs1: List[T], accumulator: List[T]): List[T] = xs1 match {
      case Nil => accumulator
      case h :: t => _reverse(t, h :: accumulator)
    }

    _reverse(xs, Nil)
  }

}
