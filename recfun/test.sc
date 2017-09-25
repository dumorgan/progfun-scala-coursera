/*
def countChange(money: Int, coins: List[Int]): Int = {
  def splitList(money: Int, coins: List[Int], changes: Int): Int = {
    if (money < 0) return 0
    if (money == 0) return changes
    if (coins.isEmpty) return changes
    if (money % coins.head == 0) {
      splitList(money - coins.head, coins.tail, changes + 1) + splitList(money, coins.tail, changes) + splitList(money - coins.head, coins, changes + 1)
    }
    else {
      splitList(money - coins.head, coins.tail, 0) + splitList(coins.head, coins.tail, 0)
    }
  }
  splitList(money, coins, 0)
}*/



def countChange(money: Int, coins:List[Int]): Int = {
  def splitList(money: Int, coins: List[Int], changes: Int): Int = {
    if (money == 0) return changes + 1
    else if (coins.isEmpty || money < 0) return changes
    else splitList(money - coins.head, coins, changes) + splitList(money, coins.tail, changes)
  }
  splitList(money, coins, 0)
}

countChange(10, List(5,2,1))