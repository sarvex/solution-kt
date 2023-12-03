import kotlin.math.max

internal class Solution {
  fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var s = 0
    var cs = 0
    val n = customers.size
    for (i in 0 until n) {
      s += customers[i] * grumpy[i]
      cs += customers[i]
    }
    var t = 0
    var ans = 0
    for (i in 0 until n) {
      t += customers[i] * grumpy[i]
      val j = i - minutes + 1
      if (j >= 0) {
        ans = max(ans.toDouble(), (cs - (s - t)).toDouble()).toInt()
        t -= customers[j] * grumpy[j]
      }
    }
    return ans
  }
}
