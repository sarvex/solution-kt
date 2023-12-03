class Solution {
  fun numberOfSets(n: Int, k: Int): Int {
    val f = Array(n + 1) { IntArray(k + 1) }
    val g = Array(n + 1) { IntArray(k + 1) }
    f[1][0] = 1
    for (i in 2..n) {
      for (j in 0..k) {
        f[i][j] = (f[i - 1][j] + g[i - 1][j]) % Solution.Companion.MOD
        g[i][j] = g[i - 1][j]
        if (j > 0) {
          g[i][j] += f[i - 1][j - 1]
          g[i][j] %= Solution.Companion.MOD
          g[i][j] += g[i - 1][j - 1]
          g[i][j] %= Solution.Companion.MOD
        }
      }
    }
    return (f[n][k] + g[n][k]) % Solution.Companion.MOD
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
