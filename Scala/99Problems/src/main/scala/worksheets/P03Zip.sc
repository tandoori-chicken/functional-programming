val xs = List(1,2,3)

val k= -1

xs.indices zip xs find { case (k1, _) => k1==k } map (_._2)