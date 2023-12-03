import kotlin.math.max

internal class Solution {
  fun findLengthOfLCIS(nums: IntArray): Int {
    var res = 1
    var i = 1
    var f = 1
    while (i < nums.size) {
      f = 1 + if (nums[i - 1] < nums[i]) f else 0
      res = max(res.toDouble(), f.toDouble()).toInt()
      ++i
    }
    return res
  }
}
