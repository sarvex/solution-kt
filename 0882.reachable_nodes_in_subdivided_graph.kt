import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun reachableNodes(edges: Array<IntArray>, maxMoves: Int, n: Int): Int {
    val g: Array<List<IntArray>?> = arrayOfNulls(n)
    Arrays.setAll(g) { e -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      val cnt = e[2] + 1
      g[u].add(intArrayOf(v, cnt))
      g[v].add(intArrayOf(u, cnt))
    }
    val dist = IntArray(n)
    Arrays.fill(dist, 1 shl 30)
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    q.offer(intArrayOf(0, 0))
    dist[0] = 0
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val d: Int = p.get(0)
      val u: Int = p.get(1)
      for (nxt in g[u]!!) {
        val v = nxt[0]
        val cnt = nxt[1]
        if (d + cnt < dist[v]) {
          dist[v] = d + cnt
          q.offer(intArrayOf(dist[v], v))
        }
      }
    }
    var ans = 0
    for (d in dist) {
      if (d <= maxMoves) {
        ++ans
      }
    }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      val cnt = e[2]
      val a = min(cnt.toDouble(), max(0.0, (maxMoves - dist[u]).toDouble())).toInt()
      val b = min(cnt.toDouble(), max(0.0, (maxMoves - dist[v]).toDouble())).toInt()
      (ans += min(cnt.toDouble(), (a + b).toDouble())).toInt()
    }
    return ans
  }
}
