class Solution {
  fun numberOfWays(n: Int, m: Int, k: Int, source: IntArray, dest: IntArray): Int {
    var k = k
    val mod = 1000000007
    var f = LongArray(4)
    f[0] = 1
    while (k-- > 0) {
      val g = LongArray(4)
      g[0] = ((n - 1) * f[1] + (m - 1) * f[2]) % mod
      g[1] = (f[0] + (n - 2) * f[1] + (m - 1) * f[3]) % mod
      g[2] = (f[0] + (m - 2) * f[2] + (n - 1) * f[3]) % mod
      g[3] = (f[1] + f[2] + (n - 2) * f[3] + (m - 2) * f[3]) % mod
      f = g
    }
    if (source[0] == dest[0]) {
      return if (source[1] == dest[1]) f[0].toInt() else f[2].toInt()
    }
    return if (source[1] == dest[1]) f[1].toInt() else f[3].toInt()
  }
}
