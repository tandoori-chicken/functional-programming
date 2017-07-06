/**
  * Created by adarsh on 05/07/2017.
  */
object P15 {
  def duplicateN[T](n: Int, list: List[T]): List[T] = list.flatMap(List.fill(n)(_))
}
