import scala.annotation.tailrec

/**
  * Created by adarsh on 03/07/2017.
  */
object P06 {
  def isPalindrome[T](xs: List[T]): Boolean = {

    @tailrec
    def _isPalindrome(curr: List[T], accumulator: List[T]): Boolean = curr match {
      case Nil => xs == accumulator
      case h :: t => _isPalindrome(t, h :: accumulator)
    }

    _isPalindrome(xs, Nil)
  }
}
