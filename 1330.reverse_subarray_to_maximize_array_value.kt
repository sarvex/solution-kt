import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxValueAfterReverse(nums: IntArray): Int {
    val n = nums.size
    var s = 0
    for (i in 0 until n - 1) {
      (s += abs((nums[i] - nums[i + 1]).toDouble())).toInt()
    }
    var ans = s
    for (i in 0 until n - 1) {
      ans = max(
        ans.toDouble(),
        (s + abs((nums[0] - nums[i + 1]).toDouble()) - abs((nums[i] - nums[i + 1]).toDouble())).toDouble()
      )
        .toInt()
      ans = max(
        ans.toDouble(),
        (s + abs((nums[n - 1] - nums[i]).toDouble()) - abs((nums[i] - nums[i + 1]).toDouble())).toDouble()
      )
        .toInt()
    }
    val dirs = intArrayOf(1, -1, -1, 1, 1)
    val inf = 1 shl 30
    for (k in 0..3) {
      val k1 = dirs[k]
      val k2 = dirs[k + 1]
      var mx = -inf
      var mi = inf
      for (i in 0 until n - 1) {
        val a = k1 * nums[i] + k2 * nums[i + 1]
        val b = abs((nums[i] - nums[i + 1]).toDouble()).toInt()
        mx = max(mx.toDouble(), (a - b).toDouble()).toInt()
        mi = min(mi.toDouble(), (a + b).toDouble()).toInt()
      }
      ans = max(ans.toDouble(), (s + max(0.0, (mx - mi).toDouble())).toDouble()).toInt()
    }
    return ans
  }
}
