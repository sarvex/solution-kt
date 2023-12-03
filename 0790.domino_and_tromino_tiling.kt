internal class Solution {
  fun numTilings(n: Int): Int {
    var f = longArrayOf(1, 0, 0, 0)
    val mod = 1e9.toInt() + 7
    for (i in 1..n) {
      val g = LongArray(4)
      g[0] = (f[0] + f[1] + f[2] + f[3]) % mod
      g[1] = (f[2] + f[3]) % mod
      g[2] = (f[1] + f[3]) % mod
      g[3] = f[0]
      f = g
    }
    return f[0].toInt()
  }
}
