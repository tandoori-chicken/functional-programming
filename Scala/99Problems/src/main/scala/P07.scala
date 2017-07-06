

/**
  * Created by adarsh on 04/07/2017.
  */
object P07 {
  def flatten(superList: List[Any]): List[Any] = superList.foldLeft(List[Any]())(flattenHelper)

  def flattenHelper(accumulator: List[Any], elem: Any): List[Any] = elem match {
    case l: List[_] => accumulator ::: flatten(l)
    case _ => accumulator :+ elem
  }
}
