import kotlin.math.min

class Solution {
  fun minimumSum(nums: IntArray): Int {
    val n = nums.size
    val right = IntArray(n + 1)
    val inf = 1 shl 30
    right[n] = inf
    for (i in n - 1 downTo 0) {
      right[i] = min(right[i + 1].toDouble(), nums[i].toDouble()).toInt()
    }
    var ans = inf
    var left = inf
    for (i in 0 until n) {
      if (left < nums[i] && right[i + 1] < nums[i]) {
        ans = min(ans.toDouble(), (left + nums[i] + right[i + 1]).toDouble()).toInt()
      }
      left = min(left.toDouble(), nums[i].toDouble()).toInt()
    }
    return if (ans == inf) -1 else ans
  }
}
