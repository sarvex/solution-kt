import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun findMaxAverage(nums: IntArray, k: Int): Double {
    val eps = 1e-5
    var l = 1e10
    var r = -1e10
    for (x in nums) {
      l = min(l, x.toDouble())
      r = max(r, x.toDouble())
    }
    while (r - l >= eps) {
      val mid = (l + r) / 2
      if (check(nums, k, mid)) {
        l = mid
      } else {
        r = mid
      }
    }
    return l
  }

  private fun check(nums: IntArray, k: Int, v: Double): Boolean {
    var s = 0.0
    for (i in 0 until k) {
      s += nums[i] - v
    }
    if (s >= 0) {
      return true
    }
    var t = 0.0
    var mi = 0.0
    for (i in k until nums.size) {
      s += nums[i] - v
      t += nums[i - k] - v
      mi = min(mi, t)
      if (s >= mi) {
        return true
      }
    }
    return false
  }
}
