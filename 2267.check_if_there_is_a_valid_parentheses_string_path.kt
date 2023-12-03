class Solution {
  private var vis: Array<Array<BooleanArray>>
  private var grid: Array<CharArray>
  private var m = 0
  private var n = 0
  fun hasValidPath(grid: Array<CharArray>): Boolean {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    vis = Array(m) { Array(n) { BooleanArray(m + n) } }
    return dfs(0, 0, 0)
  }

  private fun dfs(i: Int, j: Int, t: Int): Boolean {
    var t = t
    if (vis[i][j][t]) {
      return false
    }
    vis[i][j][t] = true
    t += if (grid[i][j] == '(') 1 else -1
    if (t < 0) {
      return false
    }
    if (i == m - 1 && j == n - 1) {
      return t == 0
    }
    val dirs = intArrayOf(0, 1, 0)
    for (k in 0..1) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x < m && y < n && dfs(x, y, t)) {
        return true
      }
    }
    return false
  }
}
