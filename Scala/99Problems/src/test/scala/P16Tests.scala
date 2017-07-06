import P16.drop
import org.scalatest.FunSuite

/**
  * Created by adarsh on 06/07/2017.
  */
class P16Tests extends FunSuite {

  test("dropping every N from empty list returns empty list for any N") {
    assert(drop(4, List()) === List())
    assert(drop(1, List()) === List())
  }

  test("dropping every 1 from any list returns empty list") {
    assert(drop(1, List('a', 'b', 'c')) === List())
    assert(drop(1, "helloworld".toList) === List())
  }

  test("dropping N from a list returns same list if N > list size") {
    val testList = List(1, 2, 3, 4, 5, 6, 7, 8)
    assert(drop(9, testList) === testList)
    assert(drop(100, testList) === testList)
  }

  test("general test case") {
    assert(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
  }

}
