internal class Solution {
  fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
    val n = nums.size
    if (n == 0) {
      return List.of(List.of(lower, upper))
    }
    val ans: List<List<Int>> = ArrayList()
    if (nums[0] > lower) {
      ans.add(List.of(lower, nums[0] - 1))
    }
    for (i in 1 until n) {
      if (nums[i] - nums[i - 1] > 1) {
        ans.add(List.of(nums[i - 1] + 1, nums[i] - 1))
      }
    }
    if (nums[n - 1] < upper) {
      ans.add(List.of(nums[n - 1] + 1, upper))
    }
    return ans
  }
}
