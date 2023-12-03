import kotlin.math.max

class Solution {
  fun maxLength(ribbons: IntArray, k: Int): Int {
    var left = 0
    var right = 0
    for (x in ribbons) {
      right = max(right.toDouble(), x.toDouble()).toInt()
    }
    while (left < right) {
      val mid = left + right + 1 ushr 1
      var cnt = 0
      for (x in ribbons) {
        cnt += x / mid
      }
      if (cnt >= k) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }
}
