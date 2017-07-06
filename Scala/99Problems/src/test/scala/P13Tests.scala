import P13._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 05/07/2017.
  */
class P13Tests extends FunSuite {

  test("encoding empty list returns empty list") {
    assert(encodeDirect(List()) === List())
  }

  test("encoding list with same element results in list of size 1") {
    assert(encodeDirect(List(4, 4, 4, 4, 4, 4, 4, 4)).size === 1)
  }

  test("general test case") {
    assert(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      === List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }

}
