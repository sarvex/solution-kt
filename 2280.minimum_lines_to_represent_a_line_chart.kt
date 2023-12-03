class Solution {
  fun minimumLines(stockPrices: Array<IntArray>): Int {
    Arrays.sort(stockPrices) { a, b -> a.get(0) - b.get(0) }
    var dx = 0
    var dy = 1
    var ans = 0
    for (i in 1 until stockPrices.size) {
      val x = stockPrices[i - 1][0]
      val y = stockPrices[i - 1][1]
      val x1 = stockPrices[i][0]
      val y1 = stockPrices[i][1]
      val dx1 = x1 - x
      val dy1 = y1 - y
      if (dy * dx1 != dx * dy1) {
        ++ans
      }
      dx = dx1
      dy = dy1
    }
    return ans
  }
}
