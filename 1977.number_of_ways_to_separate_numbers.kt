import kotlin.math.min

class Solution {
  fun numberOfCombinations(num: String): Int {
    val n = num.length
    val lcp = Array(n + 1) { IntArray(n + 1) }
    for (i in n - 1 downTo 0) {
      for (j in n - 1 downTo 0) {
        if (num[i] == num[j]) {
          lcp[i][j] = 1 + lcp[i + 1][j + 1]
        }
      }
    }
    val dp = Array(n + 1) { IntArray(n + 1) }
    dp[0][0] = 1
    for (i in 1..n) {
      for (j in 1..i) {
        var v = 0
        if (num[i - j] != '0') {
          if (i - j - j >= 0) {
            val x = lcp[i - j][i - j - j]
            if (x >= j || num[i - j + x] >= num[i - j - j + x]) {
              v = dp[i - j][j]
            }
          }
          if (v == 0) {
            v = dp[i - j][min((j - 1).toDouble(), (i - j).toDouble()).toInt()]
          }
        }
        dp[i][j] = (dp[i][j - 1] + v) % Solution.Companion.MOD
      }
    }
    return dp[n][n]
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
