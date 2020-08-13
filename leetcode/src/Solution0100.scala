import common.TreeNode

object Solution0100 {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) {
      return true
    }
    if (p == null || q == null) {
      return q == p
    }
    if (p.value == q.value) {
      return false
    }
    isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }

  def main(args: Array[String]): Unit = {
    val p = new TreeNode(1, new TreeNode(2), new TreeNode(3))
    val q = new TreeNode(1, new TreeNode(2), new TreeNode(3))
    println(isSameTree(p, q))
  }
}



