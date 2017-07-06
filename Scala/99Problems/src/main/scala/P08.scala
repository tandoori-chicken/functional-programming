/**
  * Created by adarsh on 04/07/2017.
  */
object P08 {

  def compress[T](list: List[T]): List[T] = list match {
    case Nil => list
    case h :: _ => h :: compress(list.dropWhile(_ == h))
  }

}
