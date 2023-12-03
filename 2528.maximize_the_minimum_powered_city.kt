import kotlin.math.max
import kotlin.math.min

class Solution {
  private var s: LongArray
  private var d: LongArray
  private var n = 0
  fun maxPower(stations: IntArray, r: Int, k: Int): Long {
    n = stations.size
    d = LongArray(n + 1)
    s = LongArray(n + 1)
    for (i in 0 until n) {
      val left = max(0.0, (i - r).toDouble()).toInt()
      val right = min((i + r).toDouble(), (n - 1).toDouble()).toInt()
      d[left] += stations[i].toLong()
      d[right + 1] -= stations[i].toLong()
    }
    s[0] = d[0]
    for (i in 1 until n + 1) {
      s[i] = s[i - 1] + d[i]
    }
    var left: Long = 0
    var right = 1L shl 40
    while (left < right) {
      val mid = left + right + 1 ushr 1
      if (check(mid, r, k)) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }

  private fun check(x: Long, r: Int, k: Int): Boolean {
    var k = k
    Arrays.fill(d, 0)
    var t: Long = 0
    for (i in 0 until n) {
      t += d[i]
      val dist = x - (s[i] + t)
      if (dist > 0) {
        if (k < dist) {
          return false
        }
        k -= dist.toInt()
        val j = min((i + r).toDouble(), (n - 1).toDouble()).toInt()
        val left = max(0.0, (j - r).toDouble()).toInt()
        val right = min((j + r).toDouble(), (n - 1).toDouble()).toInt()
        d[left] += dist
        d[right + 1] -= dist
        t += dist
      }
    }
    return true
  }
}
