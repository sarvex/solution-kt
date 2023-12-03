internal class Solution {
  fun numTrees(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 1
    for (i in 1..n) {
      for (j in 0 until i) {
        dp[i] += dp[j] * dp[i - j - 1]
      }
    }
    return dp[n]
  }
}
