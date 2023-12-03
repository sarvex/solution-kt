class Solution {
  fun largestPerimeter(nums: IntArray): Int {
    Arrays.sort(nums)
    for (i in nums.size - 1 downTo 2) {
      val c = nums[i - 1] + nums[i - 2]
      if (c > nums[i]) {
        return c + nums[i]
      }
    }
    return 0
  }
}
