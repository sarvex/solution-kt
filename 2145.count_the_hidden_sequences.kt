import kotlin.math.max
import kotlin.math.min

class Solution {
  fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
    var num: Long = 0
    var mi: Long = 0
    var mx: Long = 0
    for (d in differences) {
      num += d.toLong()
      mi = min(mi.toDouble(), num.toDouble()).toLong()
      mx = max(mx.toDouble(), num.toDouble()).toLong()
    }
    return max(0.0, (upper - lower - (mx - mi) + 1).toInt().toDouble()).toInt()
  }
}
