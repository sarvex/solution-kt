import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun smallestRangeI(nums: IntArray, k: Int): Int {
    var mx = 0
    var mi = 10000
    for (v in nums) {
      mx = max(mx.toDouble(), v.toDouble()).toInt()
      mi = min(mi.toDouble(), v.toDouble()).toInt()
    }
    return max(0.0, (mx - mi - k * 2).toDouble()).toInt()
  }
}
