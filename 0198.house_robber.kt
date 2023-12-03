import kotlin.math.max

internal class Solution {
  fun rob(nums: IntArray): Int {
    var f = 0
    var g = 0
    for (x in nums) {
      val ff = max(f.toDouble(), g.toDouble()).toInt()
      g = f + x
      f = ff
    }
    return max(f.toDouble(), g.toDouble()).toInt()
  }
}
