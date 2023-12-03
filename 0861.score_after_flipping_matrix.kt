import kotlin.math.max

internal class Solution {
  fun matrixScore(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
      if (grid[i][0] == 0) {
        for (j in 0 until n) {
          grid[i][j] = grid[i][j] xor 1
        }
      }
    }
    var ans = 0
    for (j in 0 until n) {
      var cnt = 0
      for (i in 0 until m) {
        cnt += grid[i][j]
      }
      (ans += max(cnt.toDouble(), (m - cnt).toDouble()) * (1 shl n - j - 1)).toInt()
    }
    return ans
  }
}
