internal class Solution {
  fun minWindow(s1: String, s2: String): String {
    val m = s1.length
    val n = s2.length
    val f = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        if (s1[i - 1] == s2[j - 1]) {
          f[i][j] = if (j == 1) i else f[i - 1][j - 1]
        } else {
          f[i][j] = f[i - 1][j]
        }
      }
    }
    var p = 0
    var k = m + 1
    for (i in 1..m) {
      if (s1[i - 1] == s2[n - 1] && f[i][n] > 0) {
        val j = f[i][n] - 1
        if (i - j < k) {
          k = i - j
          p = j
        }
      }
    }
    return if (k > m) "" else s1.substring(p, p + k)
  }
}
