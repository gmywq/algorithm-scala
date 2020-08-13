object Solution0070 {
  def climbStairs(n:Int): Int = {
    if (n == 0 || n == 1) {
      return 1
    }

    val dp = new Array[Int](n + 1)
    dp(1) = 1
    dp(2) = 2
    for( i <- 3 until n + 1){
      dp(i) = dp(i - 1) + dp(i - 2)
    }
    dp(n)
  }

  def main(args: Array[String]): Unit = {
    println(climbStairs(6))
  }
}
