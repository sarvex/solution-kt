import kotlin.math.abs
import kotlin.math.max

class Solution {
  fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
    if (sx == fx && sy == fy) {
      return t != 1
    }
    val dx = abs((sx - fx).toDouble()).toInt()
    val dy = abs((sy - fy).toDouble()).toInt()
    return max(dx.toDouble(), dy.toDouble()) <= t
  }
}
