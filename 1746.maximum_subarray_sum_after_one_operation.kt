import kotlin.math.max

class Solution {
  fun maxSumAfterOperation(nums: IntArray): Int {
    var f = 0
    var g = 0
    var ans = Int.MIN_VALUE
    for (x in nums) {
      val ff = (max(f.toDouble(), 0.0) + x).toInt()
      val gg = max((max(f.toDouble(), 0.0) + x * x).toDouble(), (g + x).toDouble()).toInt()
      f = ff
      g = gg
      ans = max(ans.toDouble(), max(f.toDouble(), g.toDouble())).toInt()
    }
    return ans
  }
}
