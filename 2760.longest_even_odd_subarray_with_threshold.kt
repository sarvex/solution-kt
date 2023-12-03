import kotlin.math.max

class Solution {
  fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
    var ans = 0
    var l = 0
    val n = nums.size
    while (l < n) {
      if (nums[l] % 2 == 0 && nums[l] <= threshold) {
        var r = l + 1
        while (r < n && nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold) {
          ++r
        }
        ans = max(ans.toDouble(), (r - l).toDouble()).toInt()
        l = r
      } else {
        ++l
      }
    }
    return ans
  }
}
