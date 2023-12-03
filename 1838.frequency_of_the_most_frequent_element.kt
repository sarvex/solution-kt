import kotlin.math.max

class Solution {
  fun maxFrequency(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    val n = nums.size
    var ans = 1
    var window = 0
    var l = 0
    var r = 1
    while (r < n) {
      window += (nums[r] - nums[r - 1]) * (r - l)
      while (window > k) {
        window -= nums[r] - nums[l++]
      }
      ans = max(ans.toDouble(), (r - l + 1).toDouble()).toInt()
      ++r
    }
    return ans
  }
}
