internal class Solution {
  fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    for (i in 0 until n) {
      while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1)
      }
    }
    for (i in 0 until n) {
      if (i + 1 != nums[i]) {
        return i + 1
      }
    }
    return n + 1
  }

  private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
