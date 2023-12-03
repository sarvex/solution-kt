class Solution {
  fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val g: Map<Int, List<Pair<Int, Boolean>>> = HashMap()
    for (e in connections) {
      val u = e[0]
      val v = e[1]
      g.computeIfAbsent(u) { k -> ArrayList() }.add(Pair(v, true.toInt()))
      g.computeIfAbsent(v) { k -> ArrayList() }.add(Pair(u, false.toInt()))
    }
    val vis = BooleanArray(n)
    return dfs(0, g, vis)
  }

  private fun dfs(u: Int, g: Map<Int, List<Pair<Int, Boolean>>>, vis: BooleanArray): Int {
    vis[u] = true
    var ans = 0
    for (e in g[u] ?: Collections.emptyList()) {
      val v: Int = e.getKey()
      val exist: Boolean = e.getValue()
      if (!vis[v]) {
        if (exist) {
          ++ans
        }
        ans += dfs(v, g, vis)
      }
    }
    return ans
  }
}
