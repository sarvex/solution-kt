import kotlin.math.min

internal class Solution {
  fun minCost(costs: Array<IntArray>): Int {
    var r = 0
    var g = 0
    var b = 0
    for (cost in costs) {
      val _r = r
      val _g = g
      val _b = b
      r = (min(_g.toDouble(), _b.toDouble()) + cost[0]).toInt()
      g = (min(_r.toDouble(), _b.toDouble()) + cost[1]).toInt()
      b = (min(_r.toDouble(), _g.toDouble()) + cost[2]).toInt()
    }
    return min(r.toDouble(), min(g.toDouble(), b.toDouble())).toInt()
  }
}
