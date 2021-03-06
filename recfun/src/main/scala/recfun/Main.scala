package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    countChange(4, List(1,2))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || (c == r)) 1
      else pascal(c, r-1) + pascal(c-1, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkNextChar(chars: List[Char], acc: Int): Boolean = {
      if (chars.isEmpty) {
        if (acc == 0) {
          return true
        }
        else return false
      }
      else {
        if (chars.head == ')') {
          if (acc == 0) return false
          else checkNextChar(chars.tail, acc - 1)
        }
        else if (chars.head == '(') checkNextChar(chars.tail, acc + 1)
        else checkNextChar(chars.tail, acc)
      }
    }
    checkNextChar(chars, 0)
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins:List[Int]): Int = {
    def splitList(money: Int, coins: List[Int], changes: Int): Int = {
      if (money == 0) return changes + 1
      else if (coins.isEmpty || money < 0) return changes
      else splitList(money - coins.head, coins, changes) + splitList(money, coins.tail, changes)
    }
    splitList(money, coins, 0)
  }
}
