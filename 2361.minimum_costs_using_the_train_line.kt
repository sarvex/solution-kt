import kotlin.math.min

class Solution {
  fun minimumCosts(regular: IntArray, express: IntArray, expressCost: Int): LongArray {
    val n = regular.size
    var f: Long = 0
    var g = (1 shl 30).toLong()
    val cost = LongArray(n)
    for (i in 0 until n) {
      val a = regular[i]
      val b = express[i]
      val ff = min((f + a).toDouble(), (g + a).toDouble()).toLong()
      val gg = min((f + expressCost + b).toDouble(), (g + b).toDouble()).toLong()
      f = ff
      g = gg
      cost[i] = min(f.toDouble(), g.toDouble()).toLong()
    }
    return cost
  }
}
