import kotlin.math.max

class Solution {
  fun maxAlternatingSum(nums: IntArray): Long {
    var f: Long = 0
    var g: Long = 0
    for (x in nums) {
      val ff = max((g - x).toDouble(), f.toDouble()).toLong()
      val gg = max((f + x).toDouble(), g.toDouble()).toLong()
      f = ff
      g = gg
    }
    return max(f.toDouble(), g.toDouble()).toLong()
  }
}
