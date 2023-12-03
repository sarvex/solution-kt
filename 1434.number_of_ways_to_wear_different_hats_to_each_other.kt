import kotlin.math.max

class Solution {
  fun numberWays(hats: List<List<Int>>): Int {
    val n: Int = hats.size()
    var m = 0
    for (h in hats) {
      for (v in h) {
        m = max(m.toDouble(), v.toDouble()).toInt()
      }
    }
    val g: Array<List<Int>?> = arrayOfNulls(m + 1)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until n) {
      for (v in hats[i]) {
        g[v].add(i)
      }
    }
    val mod = 1e9.toInt() + 7
    val f = Array(m + 1) { IntArray(1 shl n) }
    f[0][0] = 1
    for (i in 1..m) {
      for (j in 0 until (1 shl n)) {
        f[i][j] = f[i - 1][j]
        for (k in g[i]!!) {
          if (j shr k and 1 == 1) {
            f[i][j] = (f[i][j] + f[i - 1][j xor (1 shl k)]) % mod
          }
        }
      }
    }
    return f[m][(1 shl n) - 1]
  }
}
