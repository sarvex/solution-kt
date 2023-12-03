import kotlin.math.min

class Solution {
  fun minOperationsMaxProfit(customers: IntArray, boardingCost: Int, runningCost: Int): Int {
    var ans = -1
    var mx = 0
    var t = 0
    var wait = 0
    var i = 0
    while (wait > 0 || i < customers.size) {
      wait += if (i < customers.size) customers[i] else 0
      val up = min(4.0, wait.toDouble()).toInt()
      wait -= up
      ++i
      t += up * boardingCost - runningCost
      if (t > mx) {
        mx = t
        ans = i
      }
    }
    return ans
  }
}
