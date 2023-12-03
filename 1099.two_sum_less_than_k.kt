import kotlin.math.max

internal class Solution {
  fun twoSumLessThanK(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var ans = -1
    var i = 0
    var j = nums.size - 1
    while (i < j) {
      val s = nums[i] + nums[j]
      if (s < k) {
        ans = max(ans.toDouble(), s.toDouble()).toInt()
        ++i
      } else {
        --j
      }
    }
    return ans
  }
}
