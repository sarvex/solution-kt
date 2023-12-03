import kotlin.math.max

class Solution {
  fun maxSum(nums: IntArray): Int {
    var ans = -1
    val n = nums.size
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        val v = nums[i] + nums[j]
        if (ans < v && f(nums[i]) == f(nums[j])) {
          ans = v
        }
      }
    }
    return ans
  }

  private fun f(x: Int): Int {
    var x = x
    var y = 0
    while (x > 0) {
      y = max(y.toDouble(), (x % 10).toDouble()).toInt()
      x /= 10
    }
    return y
  }
}
