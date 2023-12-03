import kotlin.math.max

internal class Solution {
  fun cherryPickup(grid: Array<IntArray>): Int {
    val n = grid.size
    val dp = Array(n * 2) { Array(n) { IntArray(n) } }
    dp[0][0][0] = grid[0][0]
    for (k in 1 until n * 2 - 1) {
      for (i1 in 0 until n) {
        for (i2 in 0 until n) {
          val j1 = k - i1
          val j2 = k - i2
          dp[k][i1][i2] = Int.MIN_VALUE
          if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n || grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            continue
          }
          var t = grid[i1][j1]
          if (i1 != i2) {
            t += grid[i2][j2]
          }
          for (x1 in i1 - 1..i1) {
            for (x2 in i2 - 1..i2) {
              if (x1 >= 0 && x2 >= 0) {
                dp[k][i1][i2] = max(dp[k][i1][i2].toDouble(), (dp[k - 1][x1][x2] + t).toDouble())
                  .toInt()
              }
            }
          }
        }
      }
    }
    return max(0.0, dp[n * 2 - 2][n - 1][n - 1].toDouble()).toInt()
  }
}
