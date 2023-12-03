internal class Solution {
  fun getDescentPeriods(prices: IntArray): Long {
    var ans: Long = 0
    val n = prices.size
    var i = 0
    var j = 0
    while (i < n) {
      j = i + 1
      while (j < n && prices[j - 1] - prices[j] == 1) {
        ++j
      }
      val cnt = j - i
      ans += (1L + cnt) * cnt / 2
      i = j
    }
    return ans
  }
}
