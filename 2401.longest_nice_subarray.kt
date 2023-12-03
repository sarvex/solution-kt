import kotlin.math.max

class Solution {
  fun longestNiceSubarray(nums: IntArray): Int {
    var ans = 0
    var mask = 0
    var i = 0
    var j = 0
    while (i < nums.size) {
      while (mask and nums[i] != 0) {
        mask = mask xor nums[j++]
      }
      ans = max(ans.toDouble(), (i - j + 1).toDouble()).toInt()
      mask = mask or nums[i]
      ++i
    }
    return ans
  }
}
