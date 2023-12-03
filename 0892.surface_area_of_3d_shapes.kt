import kotlin.math.min

internal class Solution {
  fun surfaceArea(grid: Array<IntArray>): Int {
    val n = grid.size
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] > 0) {
          ans += 2 + grid[i][j] * 4
          if (i > 0) {
            (ans -= min(grid[i][j].toDouble(), grid[i - 1][j].toDouble()) * 2).toInt()
          }
          if (j > 0) {
            (ans -= min(grid[i][j].toDouble(), grid[i][j - 1].toDouble()) * 2).toInt()
          }
        }
      }
    }
    return ans
  }
}
