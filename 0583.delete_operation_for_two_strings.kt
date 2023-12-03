import kotlin.math.min

internal class Solution {
  fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      dp[i][0] = i
    }
    for (j in 1..n) {
      dp[0][j] = j
    }
    for (i in 1..m) {
      for (j in 1..n) {
        if (word1[i - 1] == word2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1]
        } else {
          dp[i][j] = (1 + min(dp[i - 1][j].toDouble(), dp[i][j - 1].toDouble())).toInt()
        }
      }
    }
    return dp[m][n]
  }
}
