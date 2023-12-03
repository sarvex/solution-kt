internal class Solution {
  fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var ans = 0
    var i = 0
    var j = 0
    var s = 1
    while (i < nums.size) {
      s *= nums[i]
      while (j <= i && s >= k) {
        s /= nums[j++]
      }
      ans += i - j + 1
      ++i
    }
    return ans
  }
}
