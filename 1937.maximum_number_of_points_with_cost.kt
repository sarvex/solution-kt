import kotlin.math.max

class Solution {
  fun maxPoints(points: Array<IntArray>): Long {
    val n = points[0].size
    var f = LongArray(n)
    val inf = 1L shl 60
    for (p in points) {
      val g = LongArray(n)
      var lmx = -inf
      var rmx = -inf
      for (j in 0 until n) {
        lmx = max(lmx.toDouble(), (f[j] + j).toDouble()).toLong()
        g[j] = max(g[j].toDouble(), (p[j] + lmx - j).toDouble()).toLong()
      }
      for (j in n - 1 downTo 0) {
        rmx = max(rmx.toDouble(), (f[j] - j).toDouble()).toLong()
        g[j] = max(g[j].toDouble(), (p[j] + rmx + j).toDouble()).toLong()
      }
      f = g
    }
    var ans: Long = 0
    for (x in f) {
      ans = max(ans.toDouble(), x.toDouble()).toLong()
    }
    return ans
  }
}
