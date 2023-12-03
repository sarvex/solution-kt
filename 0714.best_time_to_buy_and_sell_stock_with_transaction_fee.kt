import kotlin.math.max

internal class Solution {
  fun maxProfit(prices: IntArray, fee: Int): Int {
    var f0 = 0
    var f1 = -prices[0]
    for (i in 1 until prices.size) {
      val g0 = max(f0.toDouble(), (f1 + prices[i] - fee).toDouble()).toInt()
      f1 = max(f1.toDouble(), (f0 - prices[i]).toDouble()).toInt()
      f0 = g0
    }
    return f0
  }
}
