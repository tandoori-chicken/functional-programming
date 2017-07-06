import P10._

/**
  * Created by adarsh on 05/07/2017.
  */
object P11 {

  def encodeModified[T](list: List[T]): List[Any] = encode(list).map(
    {
      case (1, h) => h
      case a => a
    }
  )

}
