import kotlin.math.abs
import kotlin.math.max

internal class Solution {
  fun findMinMoves(machines: IntArray): Int {
    val n = machines.size
    var s = 0
    for (x in machines) {
      s += x
    }
    if (s % n != 0) {
      return -1
    }
    val k = s / n
    s = 0
    var ans = 0
    for (x in machines) {
      x -= k
      s += x
      ans = max(ans.toDouble(), max(abs(s.toDouble()), x.toDouble())).toInt()
    }
    return ans
  }
}
