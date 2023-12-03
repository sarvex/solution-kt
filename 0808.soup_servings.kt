internal class Solution {
  private val f = Array(200) { DoubleArray(200) }
  fun soupServings(n: Int): Double {
    return if (n > 4800) 1 else dfs((n + 24) / 25, (n + 24) / 25)
  }

  private fun dfs(i: Int, j: Int): Double {
    if (i <= 0 && j <= 0) {
      return 0.5
    }
    if (i <= 0) {
      return 1.0
    }
    if (j <= 0) {
      return 0
    }
    if (f[i][j] > 0) {
      return f[i][j]
    }
    val ans = 0.25 * (dfs(i - 4, j) + dfs(i - 3, j - 1) + dfs(i - 2, j - 2) + dfs(i - 1, j - 3))
    f[i][j] = ans
    return ans
  }
}
