import kotlin.math.min

internal class Solution {
  fun minCostClimbingStairs(cost: IntArray): Int {
    var a = 0
    var b = 0
    for (i in 1 until cost.size) {
      val c = min((a + cost[i - 1]).toDouble(), (b + cost[i]).toDouble()).toInt()
      a = b
      b = c
    }
    return b
  }
}
