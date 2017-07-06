import P08._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 04/07/2017.
  */
class P08Tests extends FunSuite {
  test("compressing empty list returns that same list") {
    assert(compress(List()) === List())
    assert(compress(Nil) === Nil)
  }

  test("compressing single element list returns that same list") {
    val testList = List("a")
    assert(compress(testList) === testList)
  }

  test("compressing list with single type of element returns list with size 1 populated by input list's head") {
    val testList = List(1, 1, 1)
    assert(compress(testList) === List(testList.head))
  }

  test("compress is not a distinct operation. Output can contain repeating elements albeit in non-consecutive positions") {
    assert(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List('a, 'b, 'c, 'a, 'd, 'e))
  }

}
