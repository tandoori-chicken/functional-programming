import scala.annotation.tailrec

/**
  * Created by adarsh on 06/07/2017.
  */
object P18 {

  def slice[T](fromIndexInclusive: Int, toIndexExclusive: Int, list: List[T]): List[T] = {
    if (fromIndexInclusive >= toIndexExclusive || toIndexExclusive < 0 || fromIndexInclusive >= list.size || list.isEmpty) Nil
    else {

      @tailrec
      def _slice(xs: List[T], curIndex: Int, accumulator: List[T]): List[T] = (xs, curIndex) match {
        case (Nil, _) => accumulator.reverse
        case (_ :: t, i) if i < fromIndexInclusive => _slice(t, i + 1, accumulator)
        case (h :: t, i) if i >= fromIndexInclusive && i < toIndexExclusive => _slice(t, i + 1, h :: accumulator)
        case (_ :: t, i) if i >= toIndexExclusive => _slice(t, i + 1, accumulator)
      }

      _slice(list, 0, Nil)
    }
  }
}
