import kotlin.math.max

class Solution {
  fun maxAscendingSum(nums: IntArray): Int {
    var ans = 0
    var t = 0
    for (i in nums.indices) {
      if (i == 0 || nums[i] > nums[i - 1]) {
        t += nums[i]
        ans = max(ans.toDouble(), t.toDouble()).toInt()
      } else {
        t = nums[i]
      }
    }
    return ans
  }
}
