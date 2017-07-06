import scala.annotation.tailrec

def drop[T](k: Int, list: List[T]): List[T] = {
  @tailrec
  def _drop(xs: List[T], ctr: Int, accumulator: List[T]): List[T] = (xs, ctr) match {
    case (Nil, _) => accumulator.reverse
    case (_ :: t, `k`) => _drop(t, 1, accumulator)
    case (h :: t, _) => _drop(t, ctr + 1, h :: accumulator)
  }

  _drop(list, 1, Nil)

}

drop(9, List(1,2,3,4,5,6,7,8))

//def drop2[T](k: Int, list: List[T]): List[T] = list.zipWithIndex.filterNot(p=>(p._2+1)%k==0 ).map(_._1)
//
//
//
//drop2(3, List(1, 2, 3, 4, 5, 6, 7, 8))