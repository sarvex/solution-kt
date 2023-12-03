import kotlin.math.max

class Solution {
  fun maxProfit(prices: IntArray, profits: IntArray): Int {
    val n = prices.size
    var ans = -1
    for (j in 0 until n) {
      var left = 0
      var right = 0
      for (i in 0 until j) {
        if (prices[i] < prices[j]) {
          left = max(left.toDouble(), profits[i].toDouble()).toInt()
        }
      }
      for (k in j + 1 until n) {
        if (prices[j] < prices[k]) {
          right = max(right.toDouble(), profits[k].toDouble()).toInt()
        }
      }
      if (left > 0 && right > 0) {
        ans = max(ans.toDouble(), (left + profits[j] + right).toDouble()).toInt()
      }
    }
    return ans
  }
}
