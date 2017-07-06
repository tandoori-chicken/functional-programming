import org.scalameter
import org.scalameter._

import scala.annotation.tailrec

/**
  * Created by adarsh on 03/07/2017.
  */

object P03 extends P03Solution {

  @tailrec
  override def kthElement[T](xs: List[T], k: Int): Option[T] = (xs, k) match {
    case (Nil, _) => None
    case (h :: _, 0) => Some(h)
    case _ if k < 0 => None
    case _ => kthElement(xs.tail, k - 1)
  }
}

object P03_Zip extends P03Solution {
  override def kthElement[T](xs: List[T], k: Int): Option[T] = xs.indices zip xs find { case (k1, _) => k1 == k } map (_._2)
}

sealed abstract class P03Solution {
  def kthElement[T](xs: List[T], k: Int): Option[T]
}

object benchmark {
  def main(args: Array[String]): Unit = {

    val testList = (0 until 1000000).toList
    val k = 999000

    val timeP03Basic = Benchmarker measureTime {
      P03.kthElement(testList, k)
    }

    val timeP03Zip = Benchmarker measureTime {
      P03_Zip.kthElement(testList, k)
    }

    println(s"Basic : $timeP03Basic and Zip : $timeP03Zip")

    val memP03Basic = Benchmarker measureMemory  {
      P03.kthElement(testList, k)
    }

    val memP03Zip = Benchmarker measureMemory  {
      P03_Zip.kthElement(testList, k)
    }

    println(s"Memory Basic : $memP03Basic and Zip : $memP03Zip")
  }
}