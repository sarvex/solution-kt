import kotlin.math.min

class Solution {
  fun minimumTime(time: IntArray, totalTrips: Int): Long {
    var mi = time[0]
    for (v in time) {
      mi = min(mi.toDouble(), v.toDouble()).toInt()
    }
    var left: Long = 1
    var right = mi.toLong() * totalTrips
    while (left < right) {
      var cnt: Long = 0
      val mid = left + right shr 1
      for (v in time) {
        cnt += mid / v
      }
      if (cnt >= totalTrips) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
