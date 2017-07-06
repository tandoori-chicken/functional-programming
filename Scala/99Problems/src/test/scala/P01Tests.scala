import P01._
import org.scalatest.FunSuite

/**
  * Created by adarsh on 03/07/2017.
  */
class P01Tests extends FunSuite {

  test("last of non-empty list is retrievable") {
    assert(last(List(1, 2, 3)).get == 3)

  }

  test("last of single element list is that element") {
    assert(last(List("a")).get == "a")
  }

  test("last element of empty list is returns None") {
    assert(last(List()) === None)
    assert(last(Nil) === None)
  }
}
