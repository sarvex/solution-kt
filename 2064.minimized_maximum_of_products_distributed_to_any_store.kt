internal class Solution {
  fun minimizedMaximum(n: Int, quantities: IntArray): Int {
    var left = 1
    var right = 1e5.toInt()
    while (left < right) {
      val mid = left + right shr 1
      var cnt = 0
      for (v in quantities) {
        cnt += (v + mid - 1) / mid
      }
      if (cnt <= n) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
