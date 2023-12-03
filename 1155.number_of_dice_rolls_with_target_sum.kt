import kotlin.math.min

internal class Solution {
  fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val mod = 1e9.toInt() + 7
    var f = IntArray(target + 1)
    f[0] = 1
    for (i in 1..n) {
      val g = IntArray(target + 1)
      for (j in 1..min(target.toDouble(), (i * k).toDouble()).toInt()) {
        for (h in 1..min(j.toDouble(), k.toDouble()).toInt()) {
          g[j] = (g[j] + f[j - h]) % mod
        }
      }
      f = g
    }
    return f[target]
  }
}
