class Solution {
  private var f: Array<IntArray>
  private var grid: Array<IntArray>
  private var m = 0
  private var n = 0
  private val mod = 1e9.toInt() + 7
  fun countPaths(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    f = Array(m) { IntArray(n) }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans = (ans + dfs(i, j)) % mod
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    if (f[i][j] != 0) {
      return f[i][j]
    }
    var ans = 1
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && grid[i][j] < grid[x][y]) {
        ans = (ans + dfs(x, y)) % mod
      }
    }
    return ans.also { f[i][j] = it }
  }
}
