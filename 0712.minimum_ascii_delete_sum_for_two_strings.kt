import kotlin.math.min

internal class Solution {
  fun minimumDeleteSum(s1: String, s2: String): Int {
    val m = s1.length
    val n = s2.length
    val f = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      f[i][0] = f[i - 1][0] + s1[i - 1].code
    }
    for (j in 1..n) {
      f[0][j] = f[0][j - 1] + s2[j - 1].code
    }
    for (i in 1..m) {
      for (j in 1..n) {
        if (s1[i - 1] == s2[j - 1]) {
          f[i][j] = f[i - 1][j - 1]
        } else {
          f[i][j] = min(
            (f[i - 1][j] + s1[i - 1].code).toDouble(),
            (f[i][j - 1] + s2[j - 1].code).toDouble()
          ).toInt()
        }
      }
    }
    return f[m][n]
  }
}
