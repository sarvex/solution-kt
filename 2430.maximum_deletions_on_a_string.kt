import kotlin.math.max

class Solution {
  fun deleteString(s: String): Int {
    val n = s.length
    val g = Array(n + 1) { IntArray(n + 1) }
    for (i in n - 1 downTo 0) {
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          g[i][j] = g[i + 1][j + 1] + 1
        }
      }
    }
    val f = IntArray(n)
    for (i in n - 1 downTo 0) {
      f[i] = 1
      for (j in 1..(n - i) / 2) {
        if (g[i][i + j] >= j) {
          f[i] = max(f[i].toDouble(), (f[i + j] + 1).toDouble()).toInt()
        }
      }
    }
    return f[0]
  }
}
