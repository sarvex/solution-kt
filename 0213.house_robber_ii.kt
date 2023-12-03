import kotlin.math.max

internal class Solution {
  fun rob(nums: IntArray): Int {
    val n = nums.size
    return if (n == 1) {
      nums[0]
    } else max(rob(nums, 0, n - 2).toDouble(), rob(nums, 1, n - 1).toDouble()).toInt()
  }

  private fun rob(nums: IntArray, l: Int, r: Int): Int {
    var l = l
    var f = 0
    var g = 0
    while (l <= r) {
      val ff = max(f.toDouble(), g.toDouble()).toInt()
      g = f + nums[l]
      f = ff
      ++l
    }
    return max(f.toDouble(), g.toDouble()).toInt()
  }
}
