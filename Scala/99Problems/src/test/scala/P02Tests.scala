import P02._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 03/07/2017.
  */
class P02Tests extends FunSuite {


  test("last but one of empty list is none") {
    assert(lastButOne(List()) === None)
  }

  test("last but one of single element list is none") {
    assert(lastButOne(List("one")) === None)
  }

  test("last but one of two element list is head") {
    val testList = List(1, 2)
    assert(lastButOne(testList).get == testList.head)
  }

  test("last but one of a list is last of init") {
    val testList = List(1,2,3,4,5)
    assert(lastButOne(testList).get === testList.init.last)
  }
}
