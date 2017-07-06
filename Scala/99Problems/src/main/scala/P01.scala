import scala.annotation.tailrec

/**
  * Created by adarsh on 03/07/2017.
  */

object P01 {

  @tailrec
  def last[T](xs: List[T]): Option[T] = xs match {
    case Nil => None
    case h :: Nil => Some(h)
    case _ :: tail => last(tail)
  }
}