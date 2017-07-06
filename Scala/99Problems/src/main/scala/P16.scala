import scala.annotation.tailrec

/**
  * Created by adarsh on 06/07/2017.
  */
object P16 {

  def drop[T](k: Int, list: List[T]): List[T] = {

    @tailrec
    def _drop(xs: List[T], ctr: Int, accumulator: List[T]): List[T] = (xs, ctr) match {
      case (Nil, _) => accumulator.reverse
      case (_ :: t, `k`) => _drop(t, 1, accumulator)
      case (h :: t, _) => _drop(t, ctr + 1, h :: accumulator)
    }

    _drop(list, 1, Nil)

  }
}
