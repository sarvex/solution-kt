class Solution {
  private var g: Array<List<IntArray>?>
  private var dist: IntArray
  private var f: IntArray
  private var n = 0
  fun countRestrictedPaths(n: Int, edges: Array<IntArray>): Int {
    this.n = n
    g = arrayOfNulls(n + 1)
    for (i in g.indices) {
      g[i] = ArrayList()
    }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      val w = e[2]
      g[u].add(intArrayOf(v, w))
      g[v].add(intArrayOf(u, w))
    }
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    q.offer(intArrayOf(0, n))
    dist = IntArray(n + 1)
    f = IntArray(n + 1)
    Arrays.fill(dist, Solution.Companion.INF)
    Arrays.fill(f, -1)
    dist[n] = 0
    while (!q.isEmpty()) {
      val p: IntArray = q.poll()
      val u = p[1]
      for (ne in g[u]!!) {
        val v = ne[0]
        val w = ne[1]
        if (dist[v] > dist[u] + w) {
          dist[v] = dist[u] + w
          q.offer(intArrayOf(dist[v], v))
        }
      }
    }
    return dfs(1)
  }

  private fun dfs(i: Int): Int {
    if (f[i] != -1) {
      return f[i]
    }
    if (i == n) {
      return 1
    }
    var ans = 0
    for (ne in g[i]!!) {
      val j = ne[0]
      if (dist[i] > dist[j]) {
        ans = (ans + dfs(j)) % Solution.Companion.MOD
      }
    }
    f[i] = ans
    return ans
  }

  companion object {
    private const val INF = Int.MAX_VALUE
    private const val MOD = 1e9.toInt() + 7
  }
}
