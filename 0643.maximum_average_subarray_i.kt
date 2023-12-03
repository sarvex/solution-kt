import kotlin.math.max

internal class Solution {
  fun findMaxAverage(nums: IntArray, k: Int): Double {
    var s = 0
    for (i in 0 until k) {
      s += nums[i]
    }
    var ans = s
    for (i in k until nums.size) {
      s += nums[i] - nums[i - k]
      ans = max(ans.toDouble(), s.toDouble()).toInt()
    }
    return ans * 1.0 / k
  }
}
