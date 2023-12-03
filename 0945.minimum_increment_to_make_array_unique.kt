class Solution {
  fun minIncrementForUnique(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 0
    for (i in 1 until nums.size) {
      if (nums[i] <= nums[i - 1]) {
        val d = nums[i - 1] - nums[i] + 1
        nums[i] += d
        ans += d
      }
    }
    return ans
  }
}
