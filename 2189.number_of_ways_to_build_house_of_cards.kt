class Solution {
  private var f: Array<Array<Int>>
  fun houseOfCards(n: Int): Int {
    f = Array(n + 1) { arrayOfNulls(n / 3) }
    return dfs(n, 0)
  }

  private fun dfs(n: Int, k: Int): Int {
    val x = 3 * k + 2
    if (x > n) {
      return 0
    }
    if (x == n) {
      return 1
    }
    return if (f[n][k] != null) {
      f[n][k]
    } else (dfs(n - x, k + 1) + dfs(n, k + 1)).also { f[n][k] = it }
  }
}
