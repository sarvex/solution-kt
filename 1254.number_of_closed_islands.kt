internal class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  fun closedIsland(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 0) {
          ans += dfs(i, j)
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    var res = if (i > 0 && i < m - 1 && j > 0 && j < n - 1) 1 else 0
    grid[i][j] = 1
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
        res = res and dfs(x, y)
      }
    }
    return res
  }
}
