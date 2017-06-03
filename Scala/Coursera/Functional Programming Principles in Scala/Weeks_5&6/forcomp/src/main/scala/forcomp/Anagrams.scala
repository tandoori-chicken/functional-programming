package forcomp


object Anagrams {

  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  /** `Occurrences` is a `List` of pairs of characters and positive integers saying
    * how often the character appears.
    * This list is sorted alphabetically w.r.t. to the character in each pair.
    * All characters in the occurrence list are lowercase.
    *
    * Any list of pairs of lowercase characters and their frequency which is not sorted
    * is **not** an occurrence list.
    *
    * Note: If the frequency of some character is zero, then that character should not be
    * in the list.
    */
  type Occurrences = List[(Char, Int)]

  /** The dictionary is simply a sequence of words.
    * It is predefined and obtained as a sequence using the utility method `loadDictionary`.
    */
  val dictionary: List[Word] = loadDictionary

  /** Converts the word into its character occurrence list.
    *
    * Note: the uppercase and lowercase version of the character are treated as the
    * same character, and are represented as a lowercase character in the occurrence list.
    *
    * Note: you must use `groupBy` to implement this method!
    */
  def occurrenceComparator(p1: (Char, Int), p2: (Char, Int)): Boolean = p1._1 < p2._1

  def wordOccurrences(w: Word): Occurrences = (w.toLowerCase groupBy identity mapValues (_.length)).toList.sortWith(occurrenceComparator)

  /** Converts a sentence into its character occurrence list. */
  def sentenceOccurrences(s: Sentence): Occurrences = if (s.isEmpty) List[(Char,Int)]() else wordOccurrences(s reduceLeft (_ + _)).sortWith(occurrenceComparator)

  /** The `dictionaryByOccurrences` is a `Map` from different occurrences to a sequence of all
    * the words that have that occurrence count.
    * This map serves as an easy way to obtain all the anagrams of a word given its occurrence list.
    *
    * For example, the word "eat" has the following character occurrence list:
    *
    * `List(('a', 1), ('e', 1), ('t', 1))`
    *
    * Incidentally, so do the words "ate" and "tea".
    *
    * This means that the `dictionaryByOccurrences` map will contain an entry:
    *
    * List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea")
    *
    */
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = dictionary groupBy wordOccurrences

  /** Returns all the anagrams of a given word. */
  def wordAnagrams(word: Word): List[Word] = dictionaryByOccurrences.get(wordOccurrences(word)).get


  def getSingleCombination(pair: (Char, Int)): List[(Char, Int)] = (for {i <- 0 to pair._2} yield (pair._1, i)).toList

  def buildList(pair1: (Char, Int), pair2: (Char, Int)) = (pair1, pair2) match {
    case ((c1,0),(c2,0))=>Nil
    case ((c1, 0), pair2) => pair2 :: Nil
    case (pair1, (c2, 0)) => pair1 :: Nil
    case _ => pair1 :: pair2 :: Nil
  }

  /** Returns the list of all subsets of the occurrence list.
    * This includes the occurrence itself, i.e. `List(('k', 1), ('o', 1))`
    * is a subset of `List(('k', 1), ('o', 1))`.
    * It also include the empty subset `List()`.
    *
    * Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
    *
    * List(
    * List(),
    * List(('a', 1)),
    * List(('a', 2)),
    * List(('b', 1)),
    * List(('a', 1), ('b', 1)),
    * List(('a', 2), ('b', 1)),
    * List(('b', 2)),
    * List(('a', 1), ('b', 2)),
    * List(('a', 2), ('b', 2))
    * )
    *
    * Note that the order of the occurrence list subsets does not matter -- the subsets
    * in the example above could have been displayed in some other order.
    */


  def combinations(occurrences: Occurrences): List[Occurrences] = {

    val superSet = for {
      o <- occurrences
      j <- 0 to o._2
    } yield (o._1, j)

    def pairCombinationApprover(pairs: List[(Char, Int)]) = pairs.map(_._1).toSet.size == pairs.size
    def pairRemoveZeros(pair: (Char, Int)) = pair._2 > 0
    def pairListRejector(pairs: List[(Char, Int)]) = pairs filter pairRemoveZeros sortWith occurrenceComparator

    superSet.toSet.subsets(occurrences.length).map(_.toList).toList filter pairCombinationApprover map pairListRejector
  }

  /** Subtracts occurrence list `y` from occurrence list `x`.
    *
    * The precondition is that the occurrence list `y` is a subset of
    * the occurrence list `x` -- any character appearing in `y` must
    * appear in `x`, and its frequency in `y` must be smaller or equal
    * than its frequency in `x`.
    *
    * Note: the resulting value is an occurrence - meaning it is sorted
    * and has no zero-entries.
    */

  def subtract(big: Occurrences, small: Occurrences): Occurrences = big match {
    case Nil => Nil
    case bigHead :: bigTail =>
      val (smallMatch, smallNonMatch) = small partition { case (c, i) => c == bigHead._1 }
      val headResult = if (smallMatch.isEmpty) bigHead else (bigHead._1, bigHead._2 - smallMatch.head._2)
      if(headResult._2==0) subtract(bigTail,smallNonMatch)
      else headResult :: subtract(bigTail, smallNonMatch)
  }

  /** Returns a list of all anagram sentences of the given sentence.
    *
    * An anagram of a sentence is formed by taking the occurrences of all the characters of
    * all the words in the sentence, and producing all possible combinations of words with those characters,
    * such that the words have to be from the dictionary.
    *
    * The number of words in the sentence and its anagrams does not have to correspond.
    * For example, the sentence `List("I", "love", "you")` is an anagram of the sentence `List("You", "olive")`.
    *
    * Also, two sentences with the same words but in a different order are considered two different anagrams.
    * For example, sentences `List("You", "olive")` and `List("olive", "you")` are different anagrams of
    * `List("I", "love", "you")`.
    *
    * Here is a full example of a sentence `List("Yes", "man")` and its anagrams for our dictionary:
    *
    * List(
    * List(en, as, my),
    * List(en, my, as),
    * List(man, yes),
    * List(men, say),
    * List(as, en, my),
    * List(as, my, en),
    * List(sane, my),
    * List(Sean, my),
    * List(my, en, as),
    * List(my, as, en),
    * List(my, sane),
    * List(my, Sean),
    * List(say, men),
    * List(yes, man)
    * )
    *
    * The different sentences do not have to be output in the order shown above - any order is fine as long as
    * all the anagrams are there. Every returned word has to exist in the dictionary.
    *
    * Note: in case that the words of the sentence are in the dictionary, then the sentence is the anagram of itself,
    * so it has to be returned in this list.
    *
    * Note: There is only one anagram of an empty sentence.
    */

  def isValidRemainingOccurrence(remainingOccurrence: Occurrences): Boolean = {
    val result = remainingOccurrence.isEmpty || sentenceAnagramsByOccurrence(remainingOccurrence).nonEmpty

    result
  }

  def getSentence(validPrefixOccurrence: Occurrences, remainingOccurrence: Occurrences): List[Sentence] = {
    val prefixWordsList = dictionaryByOccurrences.get(validPrefixOccurrence).get
    if (remainingOccurrence.isEmpty) {
      prefixWordsList map (List(_))
    }
    else {
      for {
        prefixWord <- prefixWordsList
        validRemainingSentence <- sentenceAnagramsByOccurrence(remainingOccurrence)
      } yield prefixWord :: validRemainingSentence
    }
  }

  def sentenceAnagramsByOccurrence(sentenceOccurrencesValue: Occurrences): List[Sentence] = {
    //println(sentenceOccurrencesValue)
    val validPrefixOccurrence = combinations(sentenceOccurrencesValue).filter(x => dictionaryByOccurrences.contains(x))

    val bulked = for {
      validPrefixOccurrenceSingle <- validPrefixOccurrence
      remainingOccurrence = subtract(sentenceOccurrencesValue, validPrefixOccurrenceSingle)
      if isValidRemainingOccurrence(remainingOccurrence)
    } yield getSentence(validPrefixOccurrenceSingle, remainingOccurrence)

    bulked.flatten
  }

  def sentenceAnagrams(sentence: Sentence): List[Sentence] = if(sentence.isEmpty) List(sentence) else sentenceAnagramsByOccurrence(sentenceOccurrences(sentence))


}
