class Solution {
  private var m = 0
  private var n = 0
  private var s: Array<IntArray>
  private var f: Array<Array<Array<Int>>>
  private val mod = 1e9.toInt() + 7
  fun ways(pizza: Array<String>, k: Int): Int {
    m = pizza.size
    n = pizza[0].length
    s = Array(m + 1) { IntArray(n + 1) }
    f = Array(m) { Array<Array<Int?>>(n) { arrayOfNulls(k) } }
    for (i in 1..m) {
      for (j in 1..n) {
        val x = if (pizza[i - 1][j - 1] == 'A') 1 else 0
        s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + x
      }
    }
    return dfs(0, 0, k - 1)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    if (k == 0) {
      return if (s[m][n] - s[i][n] - s[m][j] + s[i][j] > 0) 1 else 0
    }
    if (f[i][j][k] != null) {
      return f[i][j][k]
    }
    var ans = 0
    for (x in i + 1 until m) {
      if (s[x][n] - s[i][n] - s[x][j] + s[i][j] > 0) {
        ans = (ans + dfs(x, j, k - 1)) % mod
      }
    }
    for (y in j + 1 until n) {
      if (s[m][y] - s[i][y] - s[m][j] + s[i][j] > 0) {
        ans = (ans + dfs(i, y, k - 1)) % mod
      }
    }
    return ans.also { f[i][j][k] = it }
  }
}
