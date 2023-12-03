import kotlin.math.min

class Solution {
  private val inf = 2000000000
  fun modifiedGraphEdges(
    n: Int, edges: Array<IntArray?>, source: Int, destination: Int, target: Int
  ): Array<IntArray?> {
    var d = dijkstra(edges, n, source, destination)
    if (d < target) {
      return arrayOfNulls(0)
    }
    var ok = d == target.toLong()
    for (e in edges) {
      if (e!![2] > 0) {
        continue
      }
      if (ok) {
        e[2] = inf
        continue
      }
      e[2] = 1
      d = dijkstra(edges, n, source, destination)
      if (d <= target) {
        ok = true
        e[2] += (target - d).toInt()
      }
    }
    return if (ok) edges else arrayOfNulls(0)
  }

  private fun dijkstra(edges: Array<IntArray?>, n: Int, src: Int, dest: Int): Long {
    val g = Array(n) { IntArray(n) }
    val dist = LongArray(n)
    Arrays.fill(dist, inf)
    dist[src] = 0
    for (f in g) {
      Arrays.fill(f, inf)
    }
    for (e in edges) {
      val a = e!![0]
      val b = e[1]
      val w = e[2]
      if (w == -1) {
        continue
      }
      g[a][b] = w
      g[b][a] = w
    }
    val vis = BooleanArray(n)
    for (i in 0 until n) {
      var k = -1
      for (j in 0 until n) {
        if (!vis[j] && (k == -1 || dist[k] > dist[j])) {
          k = j
        }
      }
      vis[k] = true
      for (j in 0 until n) {
        dist[j] = min(dist[j].toDouble(), (dist[k] + g[k][j]).toDouble()).toLong()
      }
    }
    return dist[dest]
  }
}
