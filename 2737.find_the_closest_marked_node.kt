import kotlin.math.min

class Solution {
  fun minimumDistance(n: Int, edges: List<List<Int?>>, s: Int, marked: IntArray): Int {
    val inf = 1 shl 29
    val g = Array(n) { IntArray(n) }
    for (e in g) {
      Arrays.fill(e, inf)
    }
    for (e in edges) {
      val u: Int = e[0]
      val v: Int = e[1]
      val w: Int = e[2]
      g[u][v] = min(g[u][v].toDouble(), w.toDouble()).toInt()
    }
    val dist = IntArray(n)
    Arrays.fill(dist, inf)
    dist[s] = 0
    val vis = BooleanArray(n)
    for (i in 0 until n) {
      var t = -1
      for (j in 0 until n) {
        if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
          t = j
        }
      }
      vis[t] = true
      for (j in 0 until n) {
        dist[j] = min(dist[j].toDouble(), (dist[t] + g[t][j]).toDouble()).toInt()
      }
    }
    var ans = inf
    for (i in marked) {
      ans = min(ans.toDouble(), dist[i].toDouble()).toInt()
    }
    return if (ans >= inf) -1 else ans
  }
}
