import kotlin.math.min

class Solution {
  private var n = 0
  private var prices: IntArray
  fun minimumRelativeLosses(prices: IntArray, queries: Array<IntArray>): LongArray {
    n = prices.size
    Arrays.sort(prices)
    this.prices = prices
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + prices[i]
    }
    val q = queries.size
    val ans = LongArray(q)
    for (i in 0 until q) {
      val k = queries[i][0]
      val m = queries[i][1]
      val l = f(k, m)
      val r = m - l
      ans[i] = s[l] + 2L * k * r - (s[n] - s[n - r])
    }
    return ans
  }

  private fun f(k: Int, m: Int): Int {
    var l = 0
    var r: Int = Arrays.binarySearch(prices, k)
    if (r < 0) {
      r = -(r + 1)
    }
    r = min(m.toDouble(), r.toDouble()).toInt()
    while (l < r) {
      val mid = l + r shr 1
      val right = m - mid
      if (prices[mid] < 2L * k - prices[n - right]) {
        l = mid + 1
      } else {
        r = mid
      }
    }
    return l
  }
}
