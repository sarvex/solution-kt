import kotlin.math.min

internal class Solution {
  fun largest1BorderedSquare(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val down = Array(m) { IntArray(n) }
    val right = Array(m) { IntArray(n) }
    for (i in m - 1 downTo 0) {
      for (j in n - 1 downTo 0) {
        if (grid[i][j] == 1) {
          down[i][j] = if (i + 1 < m) down[i + 1][j] + 1 else 1
          right[i][j] = if (j + 1 < n) right[i][j + 1] + 1 else 1
        }
      }
    }
    for (k in min(m.toDouble(), n.toDouble()) downTo 1) {
      for (i in 0..m - k) {
        for (j in 0..n - k) {
          if (down[i][j] >= k && right[i][j] >= k && right[i + k - 1][j] >= k && down[i][j + k - 1] >= k) {
            return k * k
          }
        }
      }
    }
    return 0
  }
}
