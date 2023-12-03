class Solution {
  fun findMiddleIndex(nums: IntArray): Int {
    var left = 0
    var right: Int = Arrays.stream(nums).sum()
    for (i in nums.indices) {
      right -= nums[i]
      if (left == right) {
        return i
      }
      left += nums[i]
    }
    return -1
  }
}
