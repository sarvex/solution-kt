import kotlin.math.max

internal class Solution {
  fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
    val n = patience.size
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
    }
    val q: Deque<Int> = ArrayDeque()
    q.offer(0)
    val vis = BooleanArray(n)
    vis[0] = true
    var ans = 0
    var d = 0
    while (!q.isEmpty()) {
      ++d
      val t = d * 2
      for (i in q.size() downTo 1) {
        val u: Int = q.poll()
        for (v in g[u]!!) {
          if (!vis[v]) {
            vis[v] = true
            q.offer(v)
            ans = max(ans.toDouble(), ((t - 1) / patience[v] * patience[v] + t + 1).toDouble())
              .toInt()
          }
        }
      }
    }
    return ans
  }
}
