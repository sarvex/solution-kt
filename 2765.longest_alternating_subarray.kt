import kotlin.math.max

class Solution {
  fun alternatingSubarray(nums: IntArray): Int {
    var ans = -1
    val n = nums.size
    for (i in 0 until n) {
      var k = 1
      var j = i
      while (j + 1 < n && nums[j + 1] - nums[j] == k) {
        k *= -1
        ++j
      }
      if (j - i + 1 > 1) {
        ans = max(ans.toDouble(), (j - i + 1).toDouble()).toInt()
      }
    }
    return ans
  }
}
