class Solution {
  fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { Array(n) { IntArray(k) } }
    dp[0][0][grid[0][0] % k] = 1
    for (i in 0 until m) {
      for (j in 0 until n) {
        for (s in 0 until k) {
          val t = (s - grid[i][j] % k + k) % k
          if (i > 0) {
            dp[i][j][s] += dp[i - 1][j][t]
          }
          if (j > 0) {
            dp[i][j][s] += dp[i][j - 1][t]
          }
          dp[i][j][s] %= Solution.Companion.MOD
        }
      }
    }
    return dp[m - 1][n - 1][0]
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
