import scala.annotation.tailrec


/**
  * Created by adarsh on 06/07/2017.
  */
object P17 {

  def split[T](k: Int, list: List[T]): (List[T], List[T]) = if (k <= 0) (List(), list) else {

    @tailrec
    def _split(xs: List[T], counter: Int, accumulator: List[T]): (List[T], List[T]) = (xs, counter) match {
      case (Nil, _) => (accumulator.reverse, Nil) //k greater than or equal to list size
      case (h :: t, `k`) => ((h :: accumulator).reverse, t)
      case (h :: t, _) => _split(t, counter + 1, h :: accumulator)

    }

    _split(list, 1, Nil)

  }
}
