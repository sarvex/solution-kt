internal class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  fun numEnclaves(grid: Array<IntArray>): Int {
    this.grid = grid
    m = grid.size
    n = grid[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1 && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
          dfs(i, j)
        }
      }
    }
    var ans = 0
    for (row in grid) {
      for (v in row) {
        ans += v
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int) {
    grid[i][j] = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
        dfs(x, y)
      }
    }
  }
}
