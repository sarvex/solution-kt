import kotlin.math.max

internal class Solution {
  fun maxRotateFunction(nums: IntArray): Int {
    var f = 0
    var s = 0
    val n = nums.size
    for (i in 0 until n) {
      f += i * nums[i]
      s += nums[i]
    }
    var ans = f
    for (i in 1 until n) {
      f = f + s - n * nums[n - i]
      ans = max(ans.toDouble(), f.toDouble()).toInt()
    }
    return ans
  }
}
