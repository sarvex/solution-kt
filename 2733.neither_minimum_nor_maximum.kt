import kotlin.math.max
import kotlin.math.min

class Solution {
  fun findNonMinOrMax(nums: IntArray): Int {
    var mi = 100
    var mx = 0
    for (x in nums) {
      mi = min(mi.toDouble(), x.toDouble()).toInt()
      mx = max(mx.toDouble(), x.toDouble()).toInt()
    }
    for (x in nums) {
      if (x != mi && x != mx) {
        return x
      }
    }
    return -1
  }
}
