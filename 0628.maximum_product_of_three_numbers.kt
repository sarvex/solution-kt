import kotlin.math.max

internal class Solution {
  fun maximumProduct(nums: IntArray): Int {
    val inf = 1 shl 30
    var mi1 = inf
    var mi2 = inf
    var mx1 = -inf
    var mx2 = -inf
    var mx3 = -inf
    for (x in nums) {
      if (x < mi1) {
        mi2 = mi1
        mi1 = x
      } else if (x < mi2) {
        mi2 = x
      }
      if (x > mx1) {
        mx3 = mx2
        mx2 = mx1
        mx1 = x
      } else if (x > mx2) {
        mx3 = mx2
        mx2 = x
      } else if (x > mx3) {
        mx3 = x
      }
    }
    return max((mi1 * mi2 * mx1).toDouble(), (mx1 * mx2 * mx3).toDouble()).toInt()
  }
}
