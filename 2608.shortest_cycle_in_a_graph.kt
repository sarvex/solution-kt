import kotlin.math.min

class Solution {
  private var g: Array<List<Int>?>
  private val inf = 1 shl 30
  fun findShortestCycle(n: Int, edges: Array<IntArray>): Int {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
    }
    var ans = inf
    for (i in 0 until n) {
      ans = min(ans.toDouble(), bfs(i).toDouble()).toInt()
    }
    return if (ans < inf) ans else -1
  }

  private fun bfs(u: Int): Int {
    var u = u
    val dist = IntArray(g.size)
    Arrays.fill(dist, -1)
    dist[u] = 0
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(u, -1))
    var ans = inf
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      u = p.get(0)
      val fa: Int = p.get(1)
      for (v in g[u]!!) {
        if (dist[v] < 0) {
          dist[v] = dist[u] + 1
          q.offer(intArrayOf(v, u))
        } else if (v != fa) {
          ans = min(ans.toDouble(), (dist[u] + dist[v] + 1).toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
