import kotlin.math.max

internal class Solution {
  fun canJump(nums: IntArray): Boolean {
    var mx = 0
    for (i in nums.indices) {
      if (mx < i) {
        return false
      }
      mx = max(mx.toDouble(), (i + nums[i]).toDouble()).toInt()
    }
    return true
  }
}
