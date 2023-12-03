import kotlin.math.ceil

class Solution {
  fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
    var left = 1
    var right = 1e7.toInt()
    while (left < right) {
      val mid = left + right shr 1
      if (check(dist, mid, hour)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return if (check(dist, left, hour)) left else -1
  }

  private fun check(dist: IntArray, speed: Int, hour: Double): Boolean {
    var res = 0.0
    for (i in dist.indices) {
      val cost = dist[i] * 1.0 / speed
      res += if (i == dist.size - 1) cost else ceil(cost)
    }
    return res <= hour
  }
}
