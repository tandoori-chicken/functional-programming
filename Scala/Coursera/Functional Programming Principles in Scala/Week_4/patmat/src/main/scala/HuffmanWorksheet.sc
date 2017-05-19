import patmat.Huffman._

val frequencyTupleList: List[(Char, Int)] = List(('a', 5), ('b', 9), ('c', 12), ('d', 13), ('e', 16), ('f', 45))
val orderedLeafList: List[CodeTree] = makeOrderedLeafList(frequencyTupleList)
val codeTree: CodeTree = until(singleton, combine)(orderedLeafList).head



//decode(codeTree,List(0,1,0,0,1,0,1,1,1,1))
//
decodedSecret

encode(codeTree)(string2Chars("eaf"))

val table:CodeTable = convert(frenchCode)