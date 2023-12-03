import kotlin.math.max

class Solution {
  fun averageWaitingTime(customers: Array<IntArray>): Double {
    var tot = 0.0
    var t = 0
    for (e in customers) {
      val a = e[0]
      val b = e[1]
      t = (max(t.toDouble(), a.toDouble()) + b).toInt()
      tot += (t - a).toDouble()
    }
    return tot / customers.size
  }
}
