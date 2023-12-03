import kotlin.math.min

class Solution {
  fun palindromePartition(s: String, k: Int): Int {
    val n = s.length
    val g = Array(n) { IntArray(n) }
    for (i in n - 1 downTo 0) {
      for (j in i until n) {
        g[i][j] = if (s[i] != s[j]) 1 else 0
        if (i + 1 < j) {
          g[i][j] += g[i + 1][j - 1]
        }
      }
    }
    val f = Array(n + 1) { IntArray(k + 1) }
    for (i in 1..n) {
      for (j in 1..min(i.toDouble(), k.toDouble()).toInt()) {
        if (j == 1) {
          f[i][j] = g[0][i - 1]
        } else {
          f[i][j] = 10000
          for (h in j - 1 until i) {
            f[i][j] = min(f[i][j].toDouble(), (f[h][j - 1] + g[h][i - 1]).toDouble())
              .toInt()
          }
        }
      }
    }
    return f[n][k]
  }
}
