import kotlin.math.sqrt

class Solution {
  fun repairCars(ranks: IntArray, cars: Int): Long {
    var left: Long = 0
    var right = 1L * ranks[0] * cars * cars
    while (left < right) {
      val mid = left + right shr 1
      var cnt: Long = 0
      for (r in ranks) {
        (cnt += sqrt((mid / r).toDouble())).toLong()
      }
      if (cnt >= cars) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
