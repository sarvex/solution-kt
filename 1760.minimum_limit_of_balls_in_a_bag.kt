import kotlin.math.max

class Solution {
  fun minimumSize(nums: IntArray, maxOperations: Int): Int {
    var left = 1
    var right = 0
    for (x in nums) {
      right = max(right.toDouble(), x.toDouble()).toInt()
    }
    while (left < right) {
      val mid = left + right shr 1
      var cnt: Long = 0
      for (x in nums) {
        cnt += ((x - 1) / mid).toLong()
      }
      if (cnt <= maxOperations) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
