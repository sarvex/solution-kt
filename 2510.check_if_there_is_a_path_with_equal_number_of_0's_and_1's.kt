class Solution {
  private var s = 0
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  private var f: Array<Array<Array<Boolean>>>
  fun isThereAPath(grid: Array<IntArray>): Boolean {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    s = m + n - 1
    f = Array(m) { Array<Array<Boolean?>>(n) { arrayOfNulls(s) } }
    if (s % 2 == 1) {
      return false
    }
    s = s shr 1
    return dfs(0, 0, 0)
  }

  private fun dfs(i: Int, j: Int, k: Int): Boolean {
    var k = k
    if (i >= m || j >= n) {
      return false
    }
    k += grid[i][j]
    if (f[i][j][k] != null) {
      return f[i][j][k]
    }
    if (k > s || i + j + 1 - k > s) {
      return false
    }
    if (i == m - 1 && j == n - 1) {
      return k == s
    }
    f[i][j][k] = dfs(i + 1, j, k) || dfs(i, j + 1, k)
    return f[i][j][k]
  }
}
