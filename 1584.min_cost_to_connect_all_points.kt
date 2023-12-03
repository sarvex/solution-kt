import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun minCostConnectPoints(points: Array<IntArray>): Int {
    val inf = 1 shl 30
    val n = points.size
    val g = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      val x1 = points[i][0]
      val y1 = points[i][1]
      for (j in i + 1 until n) {
        val x2 = points[j][0]
        val y2 = points[j][1]
        val t = (abs((x1 - x2).toDouble()) + abs((y1 - y2).toDouble())).toInt()
        g[i][j] = t
        g[j][i] = t
      }
    }
    val dist = IntArray(n)
    val vis = BooleanArray(n)
    Arrays.fill(dist, inf)
    dist[0] = 0
    var ans = 0
    for (i in 0 until n) {
      var j = -1
      for (k in 0 until n) {
        if (!vis[k] && (j == -1 || dist[k] < dist[j])) {
          j = k
        }
      }
      vis[j] = true
      ans += dist[j]
      for (k in 0 until n) {
        if (!vis[k]) {
          dist[k] = min(dist[k].toDouble(), g[j][k].toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
