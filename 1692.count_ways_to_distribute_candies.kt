class Solution {
  fun waysToDistribute(n: Int, k: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = Array(n + 1) { IntArray(k + 1) }
    f[0][0] = 1
    for (i in 1..n) {
      for (j in 1..k) {
        f[i][j] = (f[i - 1][j].toLong() * j % mod + f[i - 1][j - 1]).toInt() % mod
      }
    }
    return f[n][k]
  }
}
