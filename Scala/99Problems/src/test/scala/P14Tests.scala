import P14._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 05/07/2017.
  */
class P14Tests extends FunSuite {

  test("empty lists are not duplicated") {
    assert(duplicate(List()) === List())
  }

  test("general test case") {
    assert(duplicate(List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
  }

}
