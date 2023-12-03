internal class Solution {
  private var m = 0
  private var n = 0
  private var f: Array<Array<IntArray>>
  fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    this.m = m
    this.n = n
    f = Array(m + 1) { Array(n + 1) { IntArray(maxMove + 1) } }
    for (a in f) {
      for (b in a) {
        Arrays.fill(b, -1)
      }
    }
    return dfs(startRow, startColumn, maxMove)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return 1
    }
    if (f[i][j][k] != -1) {
      return f[i][j][k]
    }
    if (k == 0) {
      return 0
    }
    var res = 0
    for (t in 0..3) {
      val x: Int = i + Solution.Companion.DIRS.get(t)
      val y: Int = j + Solution.Companion.DIRS.get(t + 1)
      res += dfs(x, y, k - 1)
      res %= Solution.Companion.MOD
    }
    f[i][j][k] = res
    return res
  }

  companion object {
    private val DIRS = intArrayOf(-1, 0, 1, 0, -1)
    private const val MOD = 1e9.toInt() + 7
  }
}
