import P09._

/**
  * Created by adarsh on 05/07/2017.
  */
object P10 {

  def encode[T](list:List[T]):List[(Int,T)] = pack(list).map(l => (l.size,l.head))

}
