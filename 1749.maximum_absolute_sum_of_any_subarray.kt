import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxAbsoluteSum(nums: IntArray): Int {
    var f = 0
    var g = 0
    var ans = 0
    for (x in nums) {
      f = (max(f.toDouble(), 0.0) + x).toInt()
      g = (min(g.toDouble(), 0.0) + x).toInt()
      ans = max(ans.toDouble(), max(f.toDouble(), abs(g.toDouble()))).toInt()
    }
    return ans
  }
}
