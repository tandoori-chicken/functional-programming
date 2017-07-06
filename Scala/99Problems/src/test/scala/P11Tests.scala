import P11.encodeModified
import org.scalatest.FunSuite
/**
  * Created by adarsh on 05/07/2017.
  */
class P11Tests extends FunSuite {

  test("encoding empty list returns empty list") {
    assert(encodeModified(List()) === List())
  }

  test("encoding list with same element results in list of size 1") {
    assert(encodeModified(List(4, 4, 4, 4, 4, 4, 4, 4)).size === 1)
  }

  test("general test case") {
    assert(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      === List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))
  }
}
