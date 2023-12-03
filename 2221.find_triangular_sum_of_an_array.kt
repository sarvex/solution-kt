class Solution {
  fun triangularSum(nums: IntArray): Int {
    val n = nums.size
    for (i in n downTo 0) {
      for (j in 0 until i - 1) {
        nums[j] = (nums[j] + nums[j + 1]) % 10
      }
    }
    return nums[0]
  }
}
