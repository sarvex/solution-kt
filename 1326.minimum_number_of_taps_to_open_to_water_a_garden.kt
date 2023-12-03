import kotlin.math.max

class Solution {
  fun minTaps(n: Int, ranges: IntArray): Int {
    val last = IntArray(n + 1)
    for (i in 0 until n + 1) {
      val l = max(0.0, (i - ranges[i]).toDouble()).toInt()
      val r = i + ranges[i]
      last[l] = max(last[l].toDouble(), r.toDouble()).toInt()
    }
    var ans = 0
    var mx = 0
    var pre = 0
    for (i in 0 until n) {
      mx = max(mx.toDouble(), last[i].toDouble()).toInt()
      if (mx <= i) {
        return -1
      }
      if (pre == i) {
        ++ans
        pre = mx
      }
    }
    return ans
  }
}
