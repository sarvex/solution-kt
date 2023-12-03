class Solution {
  fun countPaths(n: Int, roads: Array<IntArray>): Int {
    val g = Array(n) { LongArray(n) }
    val dist = LongArray(n)
    val w = LongArray(n)
    val vis = BooleanArray(n)
    for (i in 0 until n) {
      Arrays.fill(g[i], Solution.Companion.INF)
      Arrays.fill(dist, Solution.Companion.INF)
    }
    for (r in roads) {
      val u = r[0]
      val v = r[1]
      val t = r[2]
      g[u][v] = t.toLong()
      g[v][u] = t.toLong()
    }
    g[0][0] = 0
    dist[0] = 0
    w[0] = 1
    for (i in 0 until n) {
      var t = -1
      for (j in 0 until n) {
        if (!vis[j] && (t == -1 || dist[j] < dist[t])) {
          t = j
        }
      }
      vis[t] = true
      for (j in 0 until n) {
        if (j == t) {
          continue
        }
        val ne = dist[t] + g[t][j]
        if (dist[j] > ne) {
          dist[j] = ne
          w[j] = w[t]
        } else if (dist[j] == ne) {
          w[j] = (w[j] + w[t]) % Solution.Companion.MOD
        }
      }
    }
    return w[n - 1].toInt()
  }

  companion object {
    private const val INF = Long.MAX_VALUE / 2
    private const val MOD = 1e9.toInt() + 7
  }
}
