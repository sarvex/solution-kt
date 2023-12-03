internal class Solution {
  fun numWays(n: Int, k: Int): Int {
    val dp = Array(n) { IntArray(2) }
    dp[0][0] = k
    for (i in 1 until n) {
      dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1)
      dp[i][1] = dp[i - 1][0]
    }
    return dp[n - 1][0] + dp[n - 1][1]
  }
}
