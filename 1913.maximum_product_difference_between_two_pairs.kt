class Solution {
  fun maxProductDifference(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    return nums[n - 1] * nums[n - 2] - nums[0] * nums[1]
  }
}
