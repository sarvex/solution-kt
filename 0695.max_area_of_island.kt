import kotlin.math.max

internal class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  fun maxAreaOfIsland(grid: Array<IntArray>): Int {
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
    if (grid[i][j] == 0) {
      return 0
    }
    var ans = 1
    grid[i][j] = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n) {
        ans += dfs(x, y)
      }
    }
    return ans
  }
}
