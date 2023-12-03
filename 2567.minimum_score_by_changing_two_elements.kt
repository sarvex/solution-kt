import kotlin.math.min

class Solution {
  fun minimizeSum(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    val a = nums[n - 1] - nums[2]
    val b = nums[n - 2] - nums[1]
    val c = nums[n - 3] - nums[0]
    return min(a.toDouble(), min(b.toDouble(), c.toDouble())).toInt()
  }
}
