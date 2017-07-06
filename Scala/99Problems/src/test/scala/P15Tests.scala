import P15._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 05/07/2017.
  */
class P15Tests extends FunSuite {

  test("empty lists are not duplicated") {
    assert(duplicateN(4, List()) === List())
  }

  test("general test case") {
    assert(duplicateN(3, List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

}
