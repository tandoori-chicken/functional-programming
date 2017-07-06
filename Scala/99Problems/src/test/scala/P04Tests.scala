import P04._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 03/07/2017.
  */
class P04Tests extends FunSuite {

  test("empty list has length 0") {
    assert(length(List()) == 0)
    assert(length(Nil) == 0)
  }

  test("non empty lists are processed correctly") {
    assert(length(List(3, 4, 5)) == 3)
  }
}
