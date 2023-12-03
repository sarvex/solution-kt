import kotlin.math.max

internal class Solution {
  fun maxProfit(k: Int, prices: IntArray): Int {
    val n = prices.size
    val f = Array(k + 1) { IntArray(2) }
    for (j in 1..k) {
      f[j][1] = -prices[0]
    }
    for (i in 1 until n) {
      for (j in k downTo 1) {
        f[j][0] = max((f[j][1] + prices[i]).toDouble(), f[j][0].toDouble())
          .toInt()
        f[j][1] = max((f[j - 1][0] - prices[i]).toDouble(), f[j][1].toDouble())
          .toInt()
      }
    }
    return f[k][0]
  }
}
