class Solution {
  fun maxValue(n: Int, index: Int, maxSum: Int): Int {
    var left = 1
    var right = maxSum
    while (left < right) {
      val mid = left + right + 1 ushr 1
      if (sum((mid - 1).toLong(), index) + sum(mid.toLong(), n - index) <= maxSum) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }

  private fun sum(x: Long, cnt: Int): Long {
    return if (x >= cnt) (x + x - cnt + 1) * cnt / 2 else (x + 1) * x / 2 + cnt - x
  }
}
