import kotlin.math.min

internal class Solution {
  fun maxRunTime(n: Int, batteries: IntArray): Long {
    var l: Long = 0
    var r: Long = 0
    for (x in batteries) {
      r += x.toLong()
    }
    while (l < r) {
      val mid = l + r + 1 shr 1
      var s: Long = 0
      for (x in batteries) {
        (s += min(mid.toDouble(), x.toDouble())).toLong()
      }
      if (s >= n * mid) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }
}
