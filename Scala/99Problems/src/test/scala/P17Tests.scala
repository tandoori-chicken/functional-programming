import P17.split
import org.scalatest.FunSuite

/**
  * Created by adarsh on 06/07/2017.
  */
class P17Tests extends FunSuite {

  test("splitting at N from empty list returns pair with 2 empty lists for any N") {
    assert(split(4, List()) === (List(), List()))
    assert(split(1, List()) === (List(), List()))
  }


  test("splitting at N from a list returns pair of same list and empty list") {
    val testList = List(1, 2, 3, 4, 5, 6, 7, 8)
    assert(split(9, testList) === (testList, List()))
    assert(split(100, testList) === (testList, List()))
  }

  test("splitting at 0 from a list returns pair of empty list and same list") {
    val testList = List(1, 2, 3, 4, 5, 6, 7, 8)
    assert(split(0, testList) === (List(), testList))
  }


  test("general test case") {
    assert(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

}
