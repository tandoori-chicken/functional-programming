val l = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

def compress[T](list: List[T]): List[T] = list match {
  case Nil => list
  case h :: _ => h :: compress(list.dropWhile(_ == h))
}



compress(l)