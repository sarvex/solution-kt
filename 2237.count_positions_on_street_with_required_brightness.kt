import kotlin.math.max
import kotlin.math.min

class Solution {
  fun meetRequirement(n: Int, lights: Array<IntArray>, requirement: IntArray): Int {
    val d = IntArray(100010)
    for (e in lights) {
      val i = max(0.0, (e[0] - e[1]).toDouble()).toInt()
      val j = min((n - 1).toDouble(), (e[0] + e[1]).toDouble()).toInt()
      ++d[i]
      --d[j + 1]
    }
    var s = 0
    var ans = 0
    for (i in 0 until n) {
      s += d[i]
      if (s >= requirement[i]) {
        ++ans
      }
    }
    return ans
  }
}
