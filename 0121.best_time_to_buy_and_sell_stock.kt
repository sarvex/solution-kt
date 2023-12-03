import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxProfit(prices: IntArray): Int {
    var ans = 0
    var mi = prices[0]
    for (v in prices) {
      ans = max(ans.toDouble(), (v - mi).toDouble()).toInt()
      mi = min(mi.toDouble(), v.toDouble()).toInt()
    }
    return ans
  }
}
