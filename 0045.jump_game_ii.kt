import kotlin.math.max

internal class Solution {
  fun jump(nums: IntArray): Int {
    var ans = 0
    var mx = 0
    var last = 0
    for (i in 0 until nums.size - 1) {
      mx = max(mx.toDouble(), (i + nums[i]).toDouble()).toInt()
      if (last == i) {
        ++ans
        last = mx
      }
    }
    return ans
  }
}
