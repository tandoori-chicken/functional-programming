/**
  * Created by adarsh on 05/07/2017.
  */
object P14 {

  def duplicate[T](list:List[T]):List[T] = list.flatMap(List.fill(2)(_))

}
