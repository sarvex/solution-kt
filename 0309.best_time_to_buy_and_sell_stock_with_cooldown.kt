import kotlin.math.max

internal class Solution {
  fun maxProfit(prices: IntArray): Int {
    var f = 0
    var f0 = 0
    var f1 = -prices[0]
    for (i in 1 until prices.size) {
      val g0 = max(f0.toDouble(), (f1 + prices[i]).toDouble()).toInt()
      f1 = max(f1.toDouble(), (f - prices[i]).toDouble()).toInt()
      f = f0
      f0 = g0
    }
    return f0
  }
}
