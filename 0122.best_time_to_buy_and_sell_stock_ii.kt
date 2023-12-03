import kotlin.math.max

internal class Solution {
  fun maxProfit(prices: IntArray): Int {
    var ans = 0
    for (i in 1 until prices.size) {
      (ans += max(0.0, (prices[i] - prices[i - 1]).toDouble())).toInt()
    }
    return ans
  }
}
