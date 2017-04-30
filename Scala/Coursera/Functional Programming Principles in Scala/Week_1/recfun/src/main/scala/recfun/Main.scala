package recfun


object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1 calculate value at column c and row r of a pascal's triangle
   */
  def pascal(c: Int, r: Int): Int = {

    if (r == 0 && c == 0) 1

    else if (r < 0 || c < 0) 0

    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  }

  /**
   * Exercise 2 find out if sentence has balanced brackets given sentence as a list of chars
   */
  def balance(chars: List[Char]): Boolean = {

    def balanceInner(sentence: List[Char], balanceCount: Int): Boolean = {

      def head = sentence.head

      if (sentence.isEmpty) balanceCount == 0

      else {

        def newCount: Int =

          if (head == '(') balanceCount + 1

          else if (head == ')') balanceCount - 1

          else balanceCount

        if(newCount>=0) balanceInner(sentence.tail, newCount)

        else false //if newCount became less than 0 then analyzing remaining sentence isn't going to remedy that

      }

    }

    balanceInner(chars, 0)

  }

  /**
   * Exercise 3 find out number of ways of making change given a money amount and a list of denominations
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def countChangeInner(money: Int, coinIndex: Int): Int = {


      if (money == 0) 1

      else if (money < 0 || coinIndex < 0) 0

      else countChangeInner(money, coinIndex - 1) + countChangeInner(money - coins(coinIndex), coinIndex)
    //number of ways of making change is number of ways of making change with at least one nth denomination coin
      // plus number of ways of making change without using that nth denomination coin
    }

    countChangeInner(money, coins.length - 1)

  }

}
