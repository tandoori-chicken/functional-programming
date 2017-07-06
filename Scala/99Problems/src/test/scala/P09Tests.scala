import P09._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 05/07/2017.
  */
class P09Tests extends FunSuite {

  test("packing empty list yields empty list") {
    assert(pack(List()) === List())
  }

  test("packing list with similar entries yields result with size 1") {
    assert(pack(List(1, 1, 1, 1, 1)).size === 1)
  }

  test("general test case") {
    assert(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

}
