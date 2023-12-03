class Solution {
  fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
    val g: Array<List<Pair<Int, Double>>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in edges.indices) {
      val a = edges[i][0]
      val b = edges[i][1]
      val s = succProb[i]
      g[a].add(Pair(b, s.toInt()))
      g[b].add(Pair(a, s.toInt()))
    }
    val q: PriorityQueue<Pair<Double, Int>> = PriorityQueue(Comparator.comparingDouble(Pair::getKey))
    val d = DoubleArray(n)
    d[start] = 1.0
    q.offer(Pair(-1.0.toInt(), start))
    while (!q.isEmpty()) {
      val p: Pair<Double, Int> = q.poll()
      var w: Double = p.getKey()
      w *= -1.0
      val u: Int = p.getValue()
      for (ne in g[u]) {
        val v: Int = ne.getKey()
        val t: Double = ne.getValue()
        if (d[v] < d[u] * t) {
          d[v] = d[u] * t
          q.offer(Pair(-d[v].toInt(), v))
        }
      }
    }
    return d[end]
  }
}
