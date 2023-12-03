import kotlin.math.max

class Solution {
  private var grid: Array<IntArray>
  private var m = 0
  private var n = 0
  fun findMaxFish(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] > 0) {
          ans = max(ans.toDouble(), dfs(i, j).toDouble()).toInt()
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    var cnt = grid[i][j]
    grid[i][j] = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0) {
        cnt += dfs(x, y)
      }
    }
    return cnt
  }
}
