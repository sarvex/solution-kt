import kotlin.math.max

internal class Solution {
  fun maxSubArray(nums: IntArray): Int {
    var ans = nums[0]
    var i = 1
    var f = nums[0]
    while (i < nums.size) {
      f = (max(f.toDouble(), 0.0) + nums[i]).toInt()
      ans = max(ans.toDouble(), f.toDouble()).toInt()
      ++i
    }
    return ans
  }
}
