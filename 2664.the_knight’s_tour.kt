class Solution {
  private var g: Array<IntArray>
  private var m = 0
  private var n = 0
  private var ok = false
  fun tourOfKnight(m: Int, n: Int, r: Int, c: Int): Array<IntArray> {
    this.m = m
    this.n = n
    g = Array(m) { IntArray(n) }
    for (row in g) {
      Arrays.fill(row, -1)
    }
    g[r][c] = 0
    dfs(r, c)
    return g
  }

  private fun dfs(i: Int, j: Int) {
    if (g[i][j] == m * n - 1) {
      ok = true
      return
    }
    val dirs = intArrayOf(-2, -1, 2, 1, -2, 1, 2, -1, -2)
    for (k in 0..7) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == -1) {
        g[x][y] = g[i][j] + 1
        dfs(x, y)
        if (ok) {
          return
        }
        g[x][y] = -1
      }
    }
  }
}
