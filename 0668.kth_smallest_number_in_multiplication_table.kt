import kotlin.math.min

internal class Solution {
  fun findKthNumber(m: Int, n: Int, k: Int): Int {
    var left = 1
    var right = m * n
    while (left < right) {
      val mid = left + right ushr 1
      var cnt = 0
      for (i in 1..m) {
        (cnt += min((mid / i).toDouble(), n.toDouble())).toInt()
      }
      if (cnt >= k) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
