import kotlin.math.max

internal class Solution {
  private var grid: Array<IntArray>
  private var m = 0
  private var n = 0
  fun getMaximumGold(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans = max(ans.toDouble(), dfs(i, j).toDouble()).toInt()
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
      return 0
    }
    val t = grid[i][j]
    grid[i][j] = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    var ans = 0
    for (k in 0..3) {
      ans = max(ans.toDouble(), (t + dfs(i + dirs[k], j + dirs[k + 1])).toDouble()).toInt()
    }
    grid[i][j] = t
    return ans
  }
}
