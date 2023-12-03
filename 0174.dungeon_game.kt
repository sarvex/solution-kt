import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    val m = dungeon.size
    val n = dungeon[0].size
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (e in dp) {
      Arrays.fill(e, 1 shl 30)
    }
    dp[m - 1][n] = 1
    dp[m][n - 1] = dp[m - 1][n]
    for (i in m - 1 downTo 0) {
      for (j in n - 1 downTo 0) {
        dp[i][j] = max(1.0, (min(dp[i + 1][j].toDouble(), dp[i][j + 1].toDouble()) - dungeon[i][j]).toDouble())
          .toInt()
      }
    }
    return dp[0][0]
  }
}
