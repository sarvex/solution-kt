import kotlin.math.min

class Solution {
  fun numOfArrays(n: Int, m: Int, k: Int): Int {
    if (k == 0) {
      return 0
    }
    val dp = Array(n + 1) { Array(k + 1) { LongArray(m + 1) } }
    for (i in 1..m) {
      dp[1][1][i] = 1
    }
    for (i in 2..n) {
      for (c in 1..min(i.toDouble(), k.toDouble()).toInt()) {
        for (j in 1..m) {
          dp[i][c][j] = dp[i - 1][c][j] * j % Solution.Companion.MOD
          for (j0 in 1 until j) {
            dp[i][c][j] = (dp[i][c][j] + dp[i - 1][c - 1][j0]) % Solution.Companion.MOD
          }
        }
      }
    }
    var ans: Long = 0
    for (i in 1..m) {
      ans = (ans + dp[n][k][i]) % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
