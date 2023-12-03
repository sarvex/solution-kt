import kotlin.math.max

internal class Solution {
  fun maxKilledEnemies(grid: Array<CharArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val g = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      var t = 0
      for (j in 0 until n) {
        if (grid[i][j] == 'W') {
          t = 0
        } else if (grid[i][j] == 'E') {
          ++t
        }
        g[i][j] += t
      }
      t = 0
      for (j in n - 1 downTo 0) {
        if (grid[i][j] == 'W') {
          t = 0
        } else if (grid[i][j] == 'E') {
          ++t
        }
        g[i][j] += t
      }
    }
    for (j in 0 until n) {
      var t = 0
      for (i in 0 until m) {
        if (grid[i][j] == 'W') {
          t = 0
        } else if (grid[i][j] == 'E') {
          ++t
        }
        g[i][j] += t
      }
      t = 0
      for (i in m - 1 downTo 0) {
        if (grid[i][j] == 'W') {
          t = 0
        } else if (grid[i][j] == 'E') {
          ++t
        }
        g[i][j] += t
      }
    }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == '0') {
          ans = max(ans.toDouble(), g[i][j].toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
