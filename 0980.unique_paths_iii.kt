class Solution {
  private var m = 0
  private var n = 0
  private var cnt = 0
  private var grid: Array<IntArray>
  private var vis: Array<BooleanArray>
  fun uniquePathsIII(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    var x = 0
    var y = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 0) {
          ++cnt
        } else if (grid[i][j] == 1) {
          x = i
          y = j
        }
      }
    }
    vis = Array(m) { BooleanArray(n) }
    vis[x][y] = true
    return dfs(x, y, 0)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    if (grid[i][j] == 2) {
      return if (k == cnt + 1) 1 else 0
    }
    var ans = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (h in 0..3) {
      val x = i + dirs[h]
      val y = j + dirs[h + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] != -1) {
        vis[x][y] = true
        ans += dfs(x, y, k + 1)
        vis[x][y] = false
      }
    }
    return ans
  }
}
