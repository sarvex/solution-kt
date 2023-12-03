import kotlin.math.abs
import kotlin.math.min

internal class Solution {
  fun minDistance(height: Int, width: Int, tree: IntArray, squirrel: IntArray, nuts: Array<IntArray>): Int {
    var ans = Int.MAX_VALUE
    var s = 0
    for (a in nuts) {
      s += f(a, tree)
    }
    s *= 2
    for (a in nuts) {
      val c = f(a, tree)
      val d = f(a, squirrel) + c
      ans = min(ans.toDouble(), (s + d - c * 2).toDouble()).toInt()
    }
    return ans
  }

  private fun f(a: IntArray, b: IntArray): Int {
    return (abs((a[0] - b[0]).toDouble()) + abs((a[1] - b[1]).toDouble())).toInt()
  }
}
