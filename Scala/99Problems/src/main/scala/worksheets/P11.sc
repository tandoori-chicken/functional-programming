

def encodeModified[T](list: List[T]): List[Any] = encode(list)

encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

//  .map ({
//    case (1, t) => t
//    case a => a
//  })