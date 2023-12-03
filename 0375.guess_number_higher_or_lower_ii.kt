import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun getMoneyAmount(n: Int): Int {
    val dp = Array(n + 10) { IntArray(n + 10) }
    for (l in 2..n) {
      var i = 1
      while (i + l - 1 <= n) {
        val j = i + l - 1
        dp[i][j] = Int.MAX_VALUE
        for (k in i..j) {
          val t = (max(dp[i][k - 1].toDouble(), dp[k + 1][j].toDouble()) + k).toInt()
          dp[i][j] = min(dp[i][j].toDouble(), t.toDouble()).toInt()
        }
        ++i
      }
    }
    return dp[1][n]
  }
}
