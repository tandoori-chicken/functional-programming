/**
  * Created by adarsh on 04/07/2017.
  */
object P09 {
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case h :: _ => {
      val (taken, dropped) = xs.span(_ == h)
      taken :: pack(dropped)
    }
  }
}
