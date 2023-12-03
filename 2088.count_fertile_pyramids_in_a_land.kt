import kotlin.math.min

internal class Solution {
  fun countPyramids(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val f = Array(m) { IntArray(n) }
    var ans = 0
    for (i in m - 1 downTo 0) {
      for (j in 0 until n) {
        if (grid[i][j] == 0) {
          f[i][j] = -1
        } else if (i == m - 1 || j == 0 || j == n - 1) {
          f[i][j] = 0
        } else {
          f[i][j] = (min(
            f[i + 1][j - 1].toDouble(),
            min(f[i + 1][j].toDouble(), f[i + 1][j + 1].toDouble())
          ) + 1).toInt()
          ans += f[i][j]
        }
      }
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 0) {
          f[i][j] = -1
        } else if (i == 0 || j == 0 || j == n - 1) {
          f[i][j] = 0
        } else {
          f[i][j] = (min(
            f[i - 1][j - 1].toDouble(),
            min(f[i - 1][j].toDouble(), f[i - 1][j + 1].toDouble())
          ) + 1).toInt()
          ans += f[i][j]
        }
      }
    }
    return ans
  }
}
