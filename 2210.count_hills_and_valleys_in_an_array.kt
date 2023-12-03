class Solution {
  fun countHillValley(nums: IntArray): Int {
    var ans = 0
    var i = 1
    var j = 0
    while (i < nums.size - 1) {
      if (nums[i] == nums[i + 1]) {
        ++i
        continue
      }
      if (nums[i] > nums[j] && nums[i] > nums[i + 1]) {
        ++ans
      }
      if (nums[i] < nums[j] && nums[i] < nums[i + 1]) {
        ++ans
      }
      j = i
      ++i
    }
    return ans
  }
}
