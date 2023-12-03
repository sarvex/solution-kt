internal class Solution {
  fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
    return f(nums, right) - f(nums, left - 1)
  }

  private fun f(nums: IntArray, x: Int): Int {
    var cnt = 0
    var t = 0
    for (v in nums) {
      t = if (v > x) 0 else t + 1
      cnt += t
    }
    return cnt
  }
}
