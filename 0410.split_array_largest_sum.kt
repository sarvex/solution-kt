import kotlin.math.max

internal class Solution {
  fun splitArray(nums: IntArray, k: Int): Int {
    var left = 0
    var right = 0
    for (x in nums) {
      left = max(left.toDouble(), x.toDouble()).toInt()
      right += x
    }
    while (left < right) {
      val mid = left + right shr 1
      if (check(nums, mid, k)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun check(nums: IntArray, mx: Int, k: Int): Boolean {
    var s = 1 shl 30
    var cnt = 0
    for (x in nums) {
      s += x
      if (s > mx) {
        ++cnt
        s = x
      }
    }
    return cnt <= k
  }
}
