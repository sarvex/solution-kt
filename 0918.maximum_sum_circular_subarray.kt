import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxSubarraySumCircular(nums: IntArray): Int {
    var s1 = nums[0]
    var s2 = nums[0]
    var f1 = nums[0]
    var f2 = nums[0]
    var total = nums[0]
    for (i in 1 until nums.size) {
      total += nums[i]
      f1 = (nums[i] + max(f1.toDouble(), 0.0)).toInt()
      f2 = (nums[i] + min(f2.toDouble(), 0.0)).toInt()
      s1 = max(s1.toDouble(), f1.toDouble()).toInt()
      s2 = min(s2.toDouble(), f2.toDouble()).toInt()
    }
    return if (s1 > 0) max(s1.toDouble(), (total - s2).toDouble()).toInt() else s1
  }
}
