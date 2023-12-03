import kotlin.math.min

internal class Solution {
  fun minCostII(costs: Array<IntArray>): Int {
    val n = costs.size
    val k = costs[0].size
    var f = costs[0].clone()
    for (i in 1 until n) {
      val g = costs[i].clone()
      for (j in 0 until k) {
        var t = Int.MAX_VALUE
        for (h in 0 until k) {
          if (h != j) {
            t = min(t.toDouble(), f[h].toDouble()).toInt()
          }
        }
        g[j] += t
      }
      f = g
    }
    return Arrays.stream(f).min().getAsInt()
  }
}
