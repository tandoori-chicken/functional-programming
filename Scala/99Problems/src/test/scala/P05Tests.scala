import P05._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 03/07/2017.
  */
class P05Tests extends FunSuite {

  test("empty lists return same upon reverse") {
    assert(reverse(List()) === List())
    assert(reverse(Nil) === Nil)
  }


  test("reverse of single element lists are the same") {
    assert(reverse(List("a")) === List("a"))
  }

  test("reverse of odd element lists") {
    assert(reverse(List(1, 2, 3)) === List(3, 2, 1))
  }

  test("reverse of even element lists") {
    assert(reverse(List(1, 2)) === List(2, 1))
  }

  test("reverse of palindrome lists is same list") {
    var testPalindromeList = List(1, 2, 3, 2, 1)
    assert(reverse(testPalindromeList) === testPalindromeList)

    testPalindromeList = List(1,2,2,1)
    assert(reverse(testPalindromeList) === testPalindromeList)
  }
}
