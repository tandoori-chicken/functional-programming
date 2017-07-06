

//def encode[T](list:List[T]):List[(T,Int)] = list match {
//  case Nil => Nil
//  case h::_ => {
//    val (taken,dropped) = list span (_==h)
//    (h,taken.size)::encode(dropped)
//  }
//}
def encode[T](list:List[T]):List[(Int,T)] = pack(list).map(l => (l.size,l.head))

encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))