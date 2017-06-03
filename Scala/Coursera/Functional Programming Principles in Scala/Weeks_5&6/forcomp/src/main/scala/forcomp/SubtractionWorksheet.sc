import forcomp.Anagrams._

def subtract(big: Occurrences, small: Occurrences): Occurrences = big match {
  case Nil => Nil
  case bigHead :: bigTail =>
    val (smallMatch, smallNonMatch) = small partition { case (c, i) => c == bigHead._1 }
    val headResult = if (smallMatch.isEmpty) bigHead else (bigHead._1, bigHead._2 - smallMatch.head._2)
    if(headResult._2==0) subtract(bigTail,smallNonMatch)
    else headResult :: subtract(bigTail, smallNonMatch)
}

subtract(wordOccurrences("Hello"), wordOccurrences("Hel"))

