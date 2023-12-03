class Solution {
  fun checkPartitioning(s: String): Boolean {
    val n = s.length
    val g = Array(n) { BooleanArray(n) }
    for (e in g) {
      Arrays.fill(e, true)
    }
    for (i in n - 1 downTo 0) {
      for (j in i + 1 until n) {
        g[i][j] = s[i] == s[j] && (i + 1 == j || g[i + 1][j - 1])
      }
    }
    for (i in 0 until n - 2) {
      for (j in i + 1 until n - 1) {
        if (g[0][i] && g[i + 1][j] && g[j + 1][n - 1]) {
          return true
        }
      }
    }
    return false
  }
}
