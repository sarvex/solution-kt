import kotlin.math.max

internal class Solution {
  fun longestPalindromeSubseq(s: String): Int {
    val n = s.length
    val dp = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      dp[i][i] = 1
    }
    for (j in 1 until n) {
      for (i in j - 1 downTo 0) {
        if (s[i] == s[j]) {
          dp[i][j] = dp[i + 1][j - 1] + 2
        } else {
          dp[i][j] = max(dp[i + 1][j].toDouble(), dp[i][j - 1].toDouble())
            .toInt()
        }
      }
    }
    return dp[0][n - 1]
  }
}
