class Solution {
  fun MaxProfit(prices: IntArray): Int {
    var f1 = -prices[0]
    var f2 = 0
    var f3 = -prices[0]
    var f4 = 0
    for (i in 1 until prices.Length) {
      f1 = Math.Max(f1, -prices[i])
      f2 = Math.Max(f2, f1 + prices[i])
      f3 = Math.Max(f3, f2 - prices[i])
      f4 = Math.Max(f4, f3 + prices[i])
    }
    return f4
  }
}
