import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
    if (m * k > bloomDay.size) {
      return -1
    }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (bd in bloomDay) {
      min = min(min.toDouble(), bd.toDouble()).toInt()
      max = max(max.toDouble(), bd.toDouble()).toInt()
    }
    var left = min
    var right = max
    while (left < right) {
      val mid = left + right ushr 1
      if (check(bloomDay, m, k, mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun check(bloomDay: IntArray, m: Int, k: Int, day: Int): Boolean {
    var cnt = 0
    var cur = 0
    for (bd in bloomDay) {
      cur = if (bd <= day) cur + 1 else 0
      if (cur == k) {
        cnt++
        cur = 0
      }
    }
    return cnt >= m
  }
}
