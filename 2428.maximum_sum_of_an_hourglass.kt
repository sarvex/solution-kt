import kotlin.math.max

class Solution {
  fun maxSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var ans = 0
    for (i in 1 until m - 1) {
      for (j in 1 until n - 1) {
        var s = -grid[i][j - 1] - grid[i][j + 1]
        for (x in i - 1..i + 1) {
          for (y in j - 1..j + 1) {
            s += grid[x][y]
          }
        }
        ans = max(ans.toDouble(), s.toDouble()).toInt()
      }
    }
    return ans
  }
}
