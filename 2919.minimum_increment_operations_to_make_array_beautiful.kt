import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minIncrementOperations(nums: IntArray, k: Int): Long {
    var f: Long = 0
    var g: Long = 0
    var h: Long = 0
    for (x in nums) {
      val hh = (min(min(f.toDouble(), g.toDouble()), h.toDouble()) + max((k - x).toDouble(), 0.0)).toLong()
      f = g
      g = h
      h = hh
    }
    return min(min(f.toDouble(), g.toDouble()), h.toDouble()).toLong()
  }
}
