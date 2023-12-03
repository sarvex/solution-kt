import kotlin.math.max

internal class Solution {
  fun maximumAlternatingSubarraySum(nums: IntArray): Long {
    val inf = 1L shl 60
    var ans = -inf
    var f = -inf
    var g = -inf
    for (x in nums) {
      val ff = (max(g.toDouble(), 0.0) + x).toLong()
      g = f - x
      f = ff
      ans = max(ans.toDouble(), max(f.toDouble(), g.toDouble())).toLong()
    }
    return ans
  }
}
