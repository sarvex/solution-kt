internal class Solution {
  private var grid: Array<IntArray>
  private var color = 0
  private var m = 0
  private var n = 0
  private var vis: Array<BooleanArray>
  fun colorBorder(grid: Array<IntArray>, row: Int, col: Int, color: Int): Array<IntArray> {
    this.grid = grid
    this.color = color
    m = grid.size
    n = grid[0].size
    vis = Array(m) { BooleanArray(n) }
    dfs(row, col, grid[row][col])
    return grid
  }

  private fun dfs(i: Int, j: Int, c: Int) {
    vis[i][j] = true
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n) {
        if (!vis[x][y]) {
          if (grid[x][y] == c) {
            dfs(x, y, c)
          } else {
            grid[i][j] = color
          }
        }
      } else {
        grid[i][j] = color
      }
    }
  }
}
