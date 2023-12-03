import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minimumHealth(damage: IntArray, armor: Int): Long {
    var s: Long = 0
    var mx = damage[0]
    for (v in damage) {
      s += v.toLong()
      mx = max(mx.toDouble(), v.toDouble()).toInt()
    }
    return (s - min(mx.toDouble(), armor.toDouble()) + 1).toLong()
  }
}
