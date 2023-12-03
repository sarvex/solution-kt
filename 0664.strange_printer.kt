import kotlin.math.min

internal class Solution {
  fun strangePrinter(s: String): Int {
    val inf = 1 shl 30
    val n = s.length
    val f = Array(n) { IntArray(n) }
    for (g in f) {
      Arrays.fill(g, inf)
    }
    for (i in n - 1 downTo 0) {
      f[i][i] = 1
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          f[i][j] = f[i][j - 1]
        } else {
          for (k in i until j) {
            f[i][j] = min(f[i][j].toDouble(), (f[i][k] + f[k + 1][j]).toDouble())
              .toInt()
          }
        }
      }
    }
    return f[0][n - 1]
  }
}
