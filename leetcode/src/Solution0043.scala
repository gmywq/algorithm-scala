object Solution0043 {
  def multiply(num1: String, num2: String): String = {
    if (num1 == "0" || num2 == "0") {
      return "0"
    }
    val m = num1.length
    val n = num2.length
    var ansArr = Array.ofDim[Int](m + n)
    for (i <- (0 until m).reverse) {
      val x = num1(i).toInt - '0'
      for (j <- (0 until n).reverse) {
        ansArr(i + j + 1) += x * (num2(j).toInt - '0')
      }
    }

    for (i <- (1 until ansArr.length).reverse) {
      ansArr(i - 1) += ansArr(i) / 10
      ansArr(i) %= 10
    }

    val indx = if (ansArr(0) == 0) 1 else 0
    ansArr.drop(indx).mkString("")

  }

  def main(args: Array[String]): Unit = {
    println(multiply("3", "2"))
  }
}
