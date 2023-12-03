class Solution {
  fun beautifulPartitions(s: String, k: Int, minLength: Int): Int {
    val n = s.length
    if (!prime(s[0]) || prime(s[n - 1])) {
      return 0
    }
    val f = Array(n + 1) { IntArray(k + 1) }
    val g = Array(n + 1) { IntArray(k + 1) }
    f[0][0] = 1
    g[0][0] = 1
    for (i in 1..n) {
      if (i >= minLength && !prime(s[i - 1]) && (i == n || prime(s[i]))) {
        for (j in 1..k) {
          f[i][j] = g[i - minLength][j - 1]
        }
      }
      for (j in 0..k) {
        g[i][j] = (g[i - 1][j] + f[i][j]) % Solution.Companion.MOD
      }
    }
    return f[n][k]
  }

  private fun prime(c: Char): Boolean {
    return c == '2' || c == '3' || c == '5' || c == '7'
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
