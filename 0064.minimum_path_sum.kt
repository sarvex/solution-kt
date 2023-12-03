import kotlin.math.min

internal class Solution {
  fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val f = Array(m) { IntArray(n) }
    f[0][0] = grid[0][0]
    for (i in 1 until m) {
      f[i][0] = f[i - 1][0] + grid[i][0]
    }
    for (j in 1 until n) {
      f[0][j] = f[0][j - 1] + grid[0][j]
    }
    for (i in 1 until m) {
      for (j in 1 until n) {
        f[i][j] = (min(f[i - 1][j].toDouble(), f[i][j - 1].toDouble()) + grid[i][j]).toInt()
      }
    }
    return f[m - 1][n - 1]
  }
}
