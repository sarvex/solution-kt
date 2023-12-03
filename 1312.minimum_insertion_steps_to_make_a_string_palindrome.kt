import kotlin.math.min

class Solution {
  fun minInsertions(s: String): Int {
    val n = s.length
    val f = Array(n) { IntArray(n) }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          f[i][j] = f[i + 1][j - 1]
        } else {
          f[i][j] = (min(f[i + 1][j].toDouble(), f[i][j - 1].toDouble()) + 1).toInt()
        }
      }
    }
    return f[0][n - 1]
  }
}
