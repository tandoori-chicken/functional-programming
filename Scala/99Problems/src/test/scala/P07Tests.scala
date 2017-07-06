import P07._
import org.scalatest.FunSuite
/**
  * Created by adarsh on 04/07/2017.
  */
class P07Tests extends FunSuite {

  test("flattening a list of empty lists produces empty list") {
    assert(flatten(List(
      Nil, List(), List(), Nil
    )) === List())
  }

  test("flatten of many empty lists and one non-empty list results in that non-empty list") {
    val nonEmpty = List(1, 2, 3)
    assert(flatten(List(
      Nil, List(), nonEmpty
    )) === nonEmpty)
  }

  test("flattening lista results in list of size that is sum of contained lists") {
    val list0 = Nil
    val list1 = List(1)
    val list2 = List(2, 3)
    val list3 = List(4, 5, 6)

    val superList = List(list1, list2, list3, list0)
    val sumOfContainedListSizes: Int = superList.map(_.size).sum

    assert(flatten(superList).size === sumOfContainedListSizes)
  }

  test("flatten works for lists that are mix of lists and elements") {
    assert(flatten(
      List(
        List(1), 2, 3, List(4, 5), List(), List(6, List(7, 8), List(9), Nil)
      )
    ) === List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  }
}
