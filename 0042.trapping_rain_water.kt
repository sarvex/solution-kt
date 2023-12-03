import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun trap(height: IntArray): Int {
    val n = height.size
    val left = IntArray(n)
    val right = IntArray(n)
    left[0] = height[0]
    right[n - 1] = height[n - 1]
    for (i in 1 until n) {
      left[i] = max(left[i - 1].toDouble(), height[i].toDouble()).toInt()
      right[n - i - 1] = max(right[n - i].toDouble(), height[n - i - 1].toDouble()).toInt()
    }
    var ans = 0
    for (i in 0 until n) {
      (ans += min(left[i].toDouble(), right[i].toDouble()) - height[i]).toInt()
    }
    return ans
  }
}
