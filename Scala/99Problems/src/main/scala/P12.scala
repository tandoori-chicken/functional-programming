/**
  * Created by adarsh on 05/07/2017.
  */
object P12 {
  def decode[T](list: List[(Int, T)]): List[T] = list flatMap decodeHelper

  private def decodeHelper[T](packed: (Int, T)): List[T] = List.fill(packed._1)(packed._2)
}
