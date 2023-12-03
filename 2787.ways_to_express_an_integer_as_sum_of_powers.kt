class Solution {
  fun numberOfWays(n: Int, x: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = Array(n + 1) { IntArray(n + 1) }
    f[0][0] = 1
    for (i in 1..n) {
      val k = i.pow(x.toDouble()) as Long
      for (j in 0..n) {
        f[i][j] = f[i - 1][j]
        if (k <= j) {
          f[i][j] = (f[i][j] + f[i - 1][j - k.toInt()]) % mod
        }
      }
    }
    return f[n][n]
  }
}
