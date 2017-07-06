import org.scalatest.FunSuite

/**
  * Created by adarsh on 03/07/2017.
  */
abstract class AbstractP03SolutionTests extends FunSuite{
  
  def getSolution():P03Solution

  test("kth element of empty list is None for any k") {
    assert(getSolution().kthElement(List(), 4) === None)
    assert(getSolution().kthElement(List(), -4) === None)
    assert(getSolution().kthElement(List(), 0) === None)

    assert(getSolution().kthElement(Nil, 4) === None)
    assert(getSolution().kthElement(Nil, 0) === None)
  }

  test("kth element of any list is None if k<0 ") {
    assert(getSolution().kthElement(List(1, 2, 3), -2) === None)
  }

  test("kth element of a list is None when k is greater than equal to list size") {
    val testList = List(1, 2, 3, 4, 5) //size 5
    val listSize = testList.size

    assert(getSolution().kthElement(testList, listSize) === None)
    assert(getSolution().kthElement(testList, listSize + 1) === None)
    assert(getSolution().kthElement(testList, listSize - 1) !== None)
  }

  test("first element of a list is it's head") {
    assert(getSolution().kthElement(List("a", "b", "c"), 0) === Some("a"))
  }

  test("last element can be calculated using k = list.size-1") {
    val testList = List(1, 2, 3, 4, 5) //size 5
    val listSize = testList.size

    assert(getSolution().kthElement(testList, listSize - 1) === Some(testList.last))
  }
}
