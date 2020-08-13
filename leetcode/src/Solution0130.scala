import scala.collection.mutable

object Solution0130 {
  def solve(board: Array[Array[Char]]): Unit = {
    if (board == null || board.isEmpty) {
      return
    }
    val m = board.length
    val n = board(0).length
    val queue = new mutable.Queue[(Int, Int)]()
    for (i <- 0 until m) {
      if (board(i)(0) == 'O') {
        queue.enqueue((i, 0))
      }
      if (board(i)(n - 1) == 'O') {
        queue.enqueue((i, n - 1))
      }
    }
    for (i <- 0 until n) {
      if (board(0)(i) == 'O') {
        queue.enqueue((0, i))
      }
      if (board(m - 1)(i) == 'O') {
        queue.enqueue((m - 1, i))
      }
    }
    val direction: List[(Int, Int)] = List((-1, 0), (1, 0), (0, -1), (0, 1))
    while (queue.nonEmpty) {
      val (x, y) = queue.dequeue()
      board(x)(y) = 'A'
      for ((a, b) <- direction) {
        val nx = x + a
        val ny = y + b
        if ((0 until m contains nx) && (0 until n contains ny) && (board(nx)(ny) == 'O')) {
          queue.enqueue((nx, ny))
        }
      }
    }
    for (i <- 0 until m; j <- 0 until n) {
      if (board(i)(j) == 'A') {
        board(i)(j) = 'O'
      } else if (board(i)(j) == 'O') {
        board(i)(j) = 'X'
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val in = Array(Array('O', 'O', 'O', 'O', 'X', 'X'), Array('O', 'O', 'O', 'O', 'O', 'O'), Array('O', 'X', 'O', 'X', 'O', 'O'), Array('O', 'X', 'O', 'O', 'X', 'O'), Array('O', 'X', 'O', 'X', 'O', 'O'), Array('O', 'X', 'O', 'O', 'O', 'O'))
    in.foreach(x => println(x.mkString(" ")))
    solve(in)
    in.foreach(x => println(x.mkString(" ")))
  }
}
