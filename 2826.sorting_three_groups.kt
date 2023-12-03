import kotlin.math.min

class Solution {
  fun minimumOperations(nums: List<Int>): Int {
    var f = IntArray(3)
    for (x in nums) {
      val g = IntArray(3)
      if (x == 1) {
        g[0] = f[0]
        g[1] = (min(f[0].toDouble(), f[1].toDouble()) + 1).toInt()
        g[2] = (min(f[0].toDouble(), min(f[1].toDouble(), f[2].toDouble())) + 1).toInt()
      } else if (x == 2) {
        g[0] = f[0] + 1
        g[1] = min(f[0].toDouble(), f[1].toDouble()).toInt()
        g[2] = (min(f[0].toDouble(), min(f[1].toDouble(), f[2].toDouble())) + 1).toInt()
      } else {
        g[0] = f[0] + 1
        g[1] = (min(f[0].toDouble(), f[1].toDouble()) + 1).toInt()
        g[2] = min(f[0].toDouble(), min(f[1].toDouble(), f[2].toDouble()))
          .toInt()
      }
      f = g
    }
    return min(f[0].toDouble(), min(f[1].toDouble(), f[2].toDouble())).toInt()
  }
}
