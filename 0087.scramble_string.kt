internal class Solution {
  private var f: Array<Array<Array<Boolean>>>
  private var s1: String? = null
  private var s2: String? = null
  fun isScramble(s1: String, s2: String?): Boolean {
    val n = s1.length
    this.s1 = s1
    this.s2 = s2
    f = Array(n) { Array<Array<Boolean?>>(n) { arrayOfNulls(n + 1) } }
    return dfs(0, 0, n)
  }

  private fun dfs(i: Int, j: Int, k: Int): Boolean {
    if (f[i][j][k] != null) {
      return f[i][j][k]
    }
    if (k == 1) {
      return s1!![i] == s2!![j]
    }
    for (h in 1 until k) {
      if (dfs(i, j, h) && dfs(i + h, j + h, k - h)) {
        return true.also { f[i][j][k] = it }
      }
      if (dfs(i + h, j, k - h) && dfs(i, j + k - h, h)) {
        return true.also { f[i][j][k] = it }
      }
    }
    return false.also { f[i][j][k] = it }
  }
}
