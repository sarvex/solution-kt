class Solution {
  fun minimumWeight(n: Int, edges: Array<IntArray>, src1: Int, src2: Int, dest: Int): Long {
    val g: Array<List<Pair<Int, Long>>?> = arrayOfNulls(n)
    val rg: Array<List<Pair<Int, Long>>?> = arrayOfNulls(n)
    for (i in 0 until n) {
      g[i] = ArrayList()
      rg[i] = ArrayList()
    }
    for (e in edges) {
      val f = e[0]
      val t = e[1]
      val w = e[2].toLong()
      g[f].add(Pair(t, w.toInt()))
      rg[t].add(Pair(f, w.toInt()))
    }
    val d1 = dijkstra(g, src1)
    val d2 = dijkstra(g, src2)
    val d3 = dijkstra(rg, dest)
    var ans: Long = -1
    for (i in 0 until n) {
      if (d1[i] == Solution.Companion.INF || d2[i] == Solution.Companion.INF || d3[i] == Solution.Companion.INF) {
        continue
      }
      val t = d1[i] + d2[i] + d3[i]
      if (ans == -1L || ans > t) {
        ans = t
      }
    }
    return ans
  }

  private fun dijkstra(g: Array<List<Pair<Int, Long>>?>, u: Int): LongArray {
    var u = u
    val n = g.size
    val dist = LongArray(n)
    Arrays.fill(dist, Solution.Companion.INF)
    dist[u] = 0
    val q: PriorityQueue<Pair<Long, Int>> = PriorityQueue(Comparator.comparingLong(Pair::getKey))
    q.offer(Pair(0L.toInt(), u))
    while (!q.isEmpty()) {
      val p: Pair<Long, Int> = q.poll()
      val d: Long = p.getKey()
      u = p.getValue()
      if (d > dist[u]) {
        continue
      }
      for (e in g[u]) {
        val v: Int = e.getKey()
        val w: Long = e.getValue()
        if (dist[v] > dist[u] + w) {
          dist[v] = dist[u] + w
          q.offer(Pair(dist[v].toInt(), v))
        }
      }
    }
    return dist
  }

  companion object {
    private const val INF = Long.MAX_VALUE
  }
}
