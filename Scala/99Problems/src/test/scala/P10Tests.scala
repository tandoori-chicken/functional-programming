import P10._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 05/07/2017.
  */
class P10Tests extends FunSuite {

  test("encoding empty list returns empty list") {
    assert(encode(List()) === List())
  }

  test("encoding list with same element results in list of size 1") {
    assert(encode(List(4, 4, 4, 4, 4, 4, 4, 4)).size === 1)
  }

  test("general test case") {
    assert(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      === List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

}
