import kotlin.math.min

class Solution {
  fun connectTwoGroups(cost: List<List<Int>>): Int {
    val m: Int = cost.size()
    val n: Int = cost[0].size()
    val inf = 1 shl 30
    val f = IntArray(1 shl n)
    Arrays.fill(f, inf)
    f[0] = 0
    val g = f.clone()
    for (i in 1..m) {
      for (j in 0 until (1 shl n)) {
        g[j] = inf
        for (k in 0 until n) {
          if (j shr k and 1 == 1) {
            val c = cost[i - 1][k]
            g[j] = min(g[j].toDouble(), (g[j xor (1 shl k)] + c).toDouble()).toInt()
            g[j] = min(g[j].toDouble(), (f[j] + c).toDouble()).toInt()
            g[j] = min(g[j].toDouble(), (f[j xor (1 shl k)] + c).toDouble()).toInt()
          }
        }
      }
      System.arraycopy(g, 0, f, 0, 1 shl n)
    }
    return f[(1 shl n) - 1]
  }
}
