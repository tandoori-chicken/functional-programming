import scala.annotation.tailrec

/**
  * Created by adarsh on 03/07/2017.
  */

object P02 {

  @tailrec
  def lastButOne[T](xs: List[T]): Option[T] = xs match {
    case Nil => None
    case h :: Nil => None
    case h :: _ :: Nil => Some(h)
    case _ :: tail => lastButOne(tail)
  }
}