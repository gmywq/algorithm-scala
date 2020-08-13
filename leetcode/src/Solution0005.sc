object Solution0005 {
  def longestPalindrome(s: String): String = {
    val size = s.length()
    if (size < 2) {
      return s
    }

    var left, right: Int = 0
    // 初始化 i-j 子串表
    val dp = Array.ofDim[Boolean](size, size)
    // until 左闭右开 to 左闭右闭
    for (j <- 1 until size; i <- 0 until j) {
      dp(i)(i) = true
      dp(i)(j) = s(i) == s(j) && (j - i < 3 || dp(i + 1)(j - 1))
      if (dp(i)(j)) {
        if (right - left < j - i) {
          left = i
          right = j
        }
      }
    }
    s.slice(left, right + 1)
  }
}


println(Solution0005.longestPalindrome("abccbasf"))