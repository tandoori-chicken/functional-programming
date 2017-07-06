import P18.slice
import org.scalatest.FunSuite

/**
  * Created by adarsh on 06/07/2017.
  */
class P18Tests extends FunSuite {

  val testList = List(1, 2, 3, 4, 5, 6, 7, 8)

  test("slicing empty list returns empty list for any index") {
    assert(slice(4, 5, List()) === List())
  }

  test("slicing a non empty list with negative fromIndex and valid toIndex") {
    assert(slice(-4, 5, testList) === testList.take(5))
    assert(slice(-4, testList.size, testList) === testList)
  }

  test("slicing a non empty list with valid fromIndex and very high toIndex") {
    assert(slice(2, 100, testList) === testList.drop(2))
    assert(slice(0, 100, testList) === testList)
  }

  test("slicing a non empty list with negative fromIndex and very high toIndex returns same list") {
    assert(slice(-50, 100, testList) === testList)
  }

  test("slicing a non empty list with both indexes out of range returns empty list") {
    assert(slice(-10, 0, testList) === List())
    assert(slice(testList.size, testList.size + 100, testList) === List())
  }


  test("general test case") {
    assert(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g))
  }


}
