import quickcheck.{BinomialHeap, QuickCheckHeap}

val testHeap = new QuickCheckHeap with BinomialHeap{}
testHeap.getAllElements(testHeap.genHeap.sample.get)