class Solution {
  fun minDeletion(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    var i = 0
    while (i < n - 1) {
      if (nums[i] == nums[i + 1]) {
        ++ans
      } else {
        ++i
      }
      ++i
    }
    ans += (n - ans) % 2
    return ans
  }
}
