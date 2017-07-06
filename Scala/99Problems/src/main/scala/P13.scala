/**
  * Created by adarsh on 05/07/2017.
  */
object P13 {
  def encodeDirect[T](list: List[T]): List[(Int, T)] = list match {
    case Nil => Nil
    case h :: _ => {
      val (taken, dropped) = list span (_ == h)
      (taken.size, taken.head) :: encodeDirect(dropped)
    }
  }

}
