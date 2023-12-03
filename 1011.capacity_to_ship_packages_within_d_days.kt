import kotlin.math.max

internal class Solution {
  fun shipWithinDays(weights: IntArray, days: Int): Int {
    var left = 0
    var right = 0
    for (w in weights) {
      left = max(left.toDouble(), w.toDouble()).toInt()
      right += w
    }
    while (left < right) {
      val mid = left + right shr 1
      if (check(mid, weights, days)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun check(mx: Int, weights: IntArray, days: Int): Boolean {
    var ws = 0
    var cnt = 1
    for (w in weights) {
      ws += w
      if (ws > mx) {
        ws = w
        ++cnt
      }
    }
    return cnt <= days
  }
}
