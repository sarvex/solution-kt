internal class Solution {
  fun numberOfArithmeticSlices(nums: IntArray): Int {
    var ans = 0
    var cnt = 0
    var d = 3000
    for (i in 0 until nums.size - 1) {
      if (nums[i + 1] - nums[i] == d) {
        ++cnt
      } else {
        d = nums[i + 1] - nums[i]
        cnt = 0
      }
      ans += cnt
    }
    return ans
  }
}
