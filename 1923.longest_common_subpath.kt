import kotlin.math.max
import kotlin.math.min

class Solution {
  var N = 100010
  var h = LongArray(N)
  var p = LongArray(N)
  private var paths: Array<IntArray>
  var cnt: Map<Long, Int> = HashMap()
  var inner: Map<Long, Int> = HashMap()
  fun longestCommonSubpath(n: Int, paths: Array<IntArray>): Int {
    var left = 0
    var right = N
    for (path in paths) {
      right = min(right.toDouble(), path.size.toDouble()).toInt()
    }
    this.paths = paths
    while (left < right) {
      val mid = left + right + 1 shr 1
      if (check(mid)) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }

  private fun check(mid: Int): Boolean {
    cnt.clear()
    inner.clear()
    p[0] = 1
    for (j in paths.indices) {
      val n = paths[j].size
      for (i in 1..n) {
        p[i] = p[i - 1] * 133331
        h[i] = h[i - 1] * 133331 + paths[j][i - 1]
      }
      for (i in mid..n) {
        val `val` = get(i - mid + 1, i)
        if (!inner.containsKey(`val`) || inner[`val`] !== j) {
          inner.put(`val`, j)
          cnt.put(`val`, (cnt[`val`] ?: 0) + 1)
        }
      }
    }
    var max = 0
    for (`val` in cnt.values()) {
      max = max(max.toDouble(), `val`.toDouble()).toInt()
    }
    return max == paths.size
  }

  private operator fun get(l: Int, r: Int): Long {
    return h[r] - h[l - 1] * p[r - l + 1]
  }
}
