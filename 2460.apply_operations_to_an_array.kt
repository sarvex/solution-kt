class Solution {
  fun applyOperations(nums: IntArray): IntArray {
    val n = nums.size
    for (i in 0 until n - 1) {
      if (nums[i] == nums[i + 1]) {
        nums[i] = nums[i] shl 1
        nums[i + 1] = 0
      }
    }
    val ans = IntArray(n)
    var i = 0
    for (x in nums) {
      if (x > 0) {
        ans[i++] = x
      }
    }
    return ans
  }
}
