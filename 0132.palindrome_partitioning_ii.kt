import kotlin.math.min

internal class Solution {
  fun minCut(s: String): Int {
    val n = s.length
    val g = Array(n) { BooleanArray(n) }
    for (row in g) {
      Arrays.fill(row, true)
    }
    for (i in n - 1 downTo 0) {
      for (j in i + 1 until n) {
        g[i][j] = s[i] == s[j] && g[i + 1][j - 1]
      }
    }
    val f = IntArray(n)
    for (i in 0 until n) {
      f[i] = i
    }
    for (i in 1 until n) {
      for (j in 0..i) {
        if (g[j][i]) {
          f[i] = min(f[i].toDouble(), (if (j > 0) 1 + f[j - 1] else 0).toDouble()).toInt()
        }
      }
    }
    return f[n - 1]
  }
}
