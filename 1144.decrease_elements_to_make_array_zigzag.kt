import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun movesToMakeZigzag(nums: IntArray): Int {
    val ans = IntArray(2)
    val n = nums.size
    for (i in 0..1) {
      var j = i
      while (j < n) {
        var d = 0
        if (j > 0) {
          d = max(d.toDouble(), (nums[j] - nums[j - 1] + 1).toDouble()).toInt()
        }
        if (j < n - 1) {
          d = max(d.toDouble(), (nums[j] - nums[j + 1] + 1).toDouble()).toInt()
        }
        ans[i] += d
        j += 2
      }
    }
    return min(ans[0].toDouble(), ans[1].toDouble()).toInt()
  }
}
