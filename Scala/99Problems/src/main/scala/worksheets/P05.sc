val l = List(1, 2, 3, 4, 5)

val r = Nil

l.foldLeft(List[Int]())({ (xs, elem) => elem :: xs })

//def appendMe(xs:List[Int],elem:Int):List[Int] = elem::xs

