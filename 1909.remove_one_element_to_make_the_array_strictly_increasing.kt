class Solution {
  fun canBeIncreasing(nums: IntArray): Boolean {
    var i = 1
    val n = nums.size
    while (i < n && nums[i - 1] < nums[i]) {
      ++i
    }
    return check(nums, i - 1) || check(nums, i)
  }

  private fun check(nums: IntArray, i: Int): Boolean {
    var prev = Int.MIN_VALUE
    for (j in nums.indices) {
      if (i == j) {
        continue
      }
      if (prev >= nums[j]) {
        return false
      }
      prev = nums[j]
    }
    return true
  }
}
