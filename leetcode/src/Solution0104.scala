import common.TreeNode

object Solution0104 {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0 else (1 + Math.max(maxDepth(root.left), maxDepth(root.right)))
  }

  def main(args: Array[String]): Unit = {
    val p = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(3))), new TreeNode(3))

    println(maxDepth(p))
  }
}
