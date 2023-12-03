import kotlin.math.min

class Solution {
  fun shortestPathWithHops(n: Int, edges: Array<IntArray>, s: Int, d: Int, k: Int): Int {
    val g: Array<List<IntArray>?> = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      val w = e[2]
      g[u].add(intArrayOf(v, w))
      g[v].add(intArrayOf(u, w))
    }
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    pq.offer(intArrayOf(0, s, 0))
    val dist = Array(n) { IntArray(k + 1) }
    val inf = 1 shl 30
    for (e in dist) {
      Arrays.fill(e, inf)
    }
    dist[s][0] = 0
    while (!pq.isEmpty()) {
      val p: IntArray = pq.poll()
      val dis = p[0]
      val u = p[1]
      val t = p[2]
      for (e in g[u]!!) {
        val v = e[0]
        val w = e[1]
        if (t + 1 <= k && dist[v][t + 1] > dis) {
          dist[v][t + 1] = dis
          pq.offer(intArrayOf(dis, v, t + 1))
        }
        if (dist[v][t] > dis + w) {
          dist[v][t] = dis + w
          pq.offer(intArrayOf(dis + w, v, t))
        }
      }
    }
    var ans = inf
    for (i in 0..k) {
      ans = min(ans.toDouble(), dist[d][i].toDouble()).toInt()
    }
    return ans
  }
}
