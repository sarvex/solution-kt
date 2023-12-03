internal class Solution {
  private var g: Map<Int, Set<Int>>? = null
  private var vis: BooleanArray
  private var next = 0
  private var ans = 0
  fun treeDiameter(edges: Array<IntArray>): Int {
    val n = edges.size
    ans = 0
    g = HashMap()
    for (e in edges) {
      g.computeIfAbsent(e[0]) { k -> HashSet() }.add(e[1])
      g.computeIfAbsent(e[1]) { k -> HashSet() }.add(e[0])
    }
    vis = BooleanArray(n + 1)
    next = edges[0][0]
    dfs(next, 0)
    vis = BooleanArray(n + 1)
    dfs(next, 0)
    return ans
  }

  private fun dfs(u: Int, t: Int) {
    if (vis[u]) {
      return
    }
    vis[u] = true
    if (ans < t) {
      ans = t
      next = u
    }
    for (v in g!![u]!!) {
      dfs(v, t + 1)
    }
  }
}
