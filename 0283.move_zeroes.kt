internal class Solution {
  fun moveZeroes(nums: IntArray) {
    var i = -1
    val n = nums.size
    for (j in 0 until n) {
      if (nums[j] != 0) {
        val t = nums[++i]
        nums[i] = nums[j]
        nums[j] = t
      }
    }
  }
}
