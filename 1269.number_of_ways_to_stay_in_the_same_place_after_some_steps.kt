class Solution {
  private var f: Array<Array<Int>>
  private var n = 0
  fun numWays(steps: Int, arrLen: Int): Int {
    f = Array(steps) { arrayOfNulls(steps + 1) }
    n = arrLen
    return dfs(0, steps)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i > j || i >= n || i < 0 || j < 0) {
      return 0
    }
    if (i == 0 && j == 0) {
      return 1
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 0
    val mod = 1e9.toInt() + 7
    for (k in -1..1) {
      ans = (ans + dfs(i + k, j - 1)) % mod
    }
    return ans.also { f[i][j] = it }
  }
}
