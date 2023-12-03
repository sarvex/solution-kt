class Solution {
  fun countSubstrings(s: String, t: String): Int {
    var ans = 0
    val m = s.length
    val n = t.length
    val f = Array(m + 1) { IntArray(n + 1) }
    val g = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (s[i] == t[j]) {
          f[i + 1][j + 1] = f[i][j] + 1
        }
      }
    }
    for (i in m - 1 downTo 0) {
      for (j in n - 1 downTo 0) {
        if (s[i] == t[j]) {
          g[i][j] = g[i + 1][j + 1] + 1
        } else {
          ans += (f[i][j] + 1) * (g[i + 1][j + 1] + 1)
        }
      }
    }
    return ans
  }
}
