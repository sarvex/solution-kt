import kotlin.math.min

internal class Solution {
  fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
    var m = m
    var n = n
    for (op in ops) {
      m = min(m.toDouble(), op[0].toDouble()).toInt()
      n = min(n.toDouble(), op[1].toDouble()).toInt()
    }
    return m * n
  }
}
