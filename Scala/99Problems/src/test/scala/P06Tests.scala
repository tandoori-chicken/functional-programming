import P06._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 04/07/2017.
  */
class P06Tests extends FunSuite {

  test("empty lists are palindromes") {
    assert(isPalindrome(List()))
    assert(isPalindrome(Nil))
  }

  test("single element lists are palindromes") {
    assert(isPalindrome(List(1)))
    assert(isPalindrome(List("d")))
  }

  test("other general true cases") {
    assert(isPalindrome("abba".toList))
    assert(isPalindrome(List(1, 3, 1)))
    assert(isPalindrome("aa".toList))
  }

  test("other general false cases") {
    assert(!isPalindrome("abc".toList))
    assert(!isPalindrome("ab".toList))
  }

}
