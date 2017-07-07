package quickcheck

import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._
import org.scalacheck.Prop._
import org.scalacheck._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    k <- arbitrary[A]
    m <- oneOf(const(empty), genHeap)
  } yield insert(k, m)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("gen2") = forAll { (h: H) =>
    if (!isEmpty(h)) true
    else {
      findMin(insert(1, insert(2, h))) == 1
      findMin(insert(2, insert(1, h))) == 1
    }
  }

  property("oddly melded lists are equal") = forAll { (h1: H, h2: H) =>
    def isHeapEqual(h1: H, h2: H): Boolean = {
      def isEqualIter( status: Boolean, h1: H, h2: H): Boolean = {
        if (isEmpty(h1))
          if (isEmpty(h2))
            true
          else
            false
        else
          status && isEqualIter(findMin(h1) == findMin(h2), deleteMin(h1), deleteMin(h2))
      }

      isEqualIter( true, h1, h2)
    }

    isHeapEqual(meld(deleteMin(h1), insert(findMin(h1), h2)), meld(h1, h2))
  }

  property("min(x meld y) is either min(x) or min(y)") = forAll { (h1: H, h2: H) =>
    val melded = meld(h1, h2)
    findMin(melded) == math.min(findMin(h1), findMin(h2))
  }

  property("meld keeps all of both") = {
    val h1 = insert(1, insert(2, insert(3, insert(4, empty))))
    val h2 = insert(5, insert(6, insert(7, insert(8, empty))))
    val melded = meld(h2, h1)
    findMin(deleteMin(melded)) == 2
  }

  property("gen3") = forAll { (h: H) =>
    if (!isEmpty(h)) true
    else {
      deleteMin(insert(1, h)) == empty
    }
  }

  property("gen4") = forAll { (h1: H, h2: H) =>
    if (isEmpty(h1) || isEmpty(h2)) true
    else {
      val min1 = findMin(h1)
      val min2 = findMin(h2)
      val minTotal = findMin(meld(h1, h2))
      minTotal == Math.min(min1, min2)
    }
  }

  property("gen5") = forAll { (h: H) =>
    isSorted(getAllElements(h))
  }

  def isSorted(l: List[A]): Boolean = l match {
    case Nil => true
    case h :: Nil => true
    case h :: tail => (h <= tail.head) && isSorted(tail)
  }

  def getAllElements(h: H): List[A] = if (isEmpty(h)) List[A]() else findMin(h) :: getAllElements(deleteMin(h))
}
