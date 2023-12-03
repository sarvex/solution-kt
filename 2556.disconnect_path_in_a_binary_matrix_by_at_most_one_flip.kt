class Solution {
  private var grid: Array<IntArray>
  private var m = 0
  private var n = 0
  fun isPossibleToCutPath(grid: Array<IntArray>): Boolean {
    this.grid = grid
    m = grid.size
    n = grid[0].size
    val a = dfs(0, 0)
    grid[0][0] = 1
    grid[m - 1][n - 1] = 1
    val b = dfs(0, 0)
    return !(a && b)
  }

  private fun dfs(i: Int, j: Int): Boolean {
    if (i >= m || j >= n || grid[i][j] == 0) {
      return false
    }
    if (i == m - 1 && j == n - 1) {
      return true
    }
    grid[i][j] = 0
    return dfs(i + 1, j) || dfs(i, j + 1)
  }
}
