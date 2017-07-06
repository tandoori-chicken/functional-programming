import P12._
import P10._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 05/07/2017.
  */
class P12Tests extends FunSuite {

  test("decoding empty list returns empty list") {
    assert(decode(List()) === List())
  }

  test("general test case") {
    assert(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
      === List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }

  test("decode is reverse of encode") {
    val inputList = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val encoded = encode(inputList)
    val decoded = decode(encoded)
    assert(decoded === inputList)
  }
}
