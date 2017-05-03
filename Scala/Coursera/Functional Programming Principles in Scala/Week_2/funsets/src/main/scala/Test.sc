
type Set = Int => Boolean

def contains(s: Set, elem: Int): Boolean = s(elem)

val f:Int=>Int=_*2

val s:Set = List(1,3,4,5,7,1000).contains(_)

val xs = for (i <- -1000 to 1000 if contains(s, i)) yield i

val mapped = xs map f

val t:Set = mapped.contains(_)


