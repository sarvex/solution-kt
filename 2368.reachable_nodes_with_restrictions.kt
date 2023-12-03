class Solution {
  private var g: Array<List<Int>?>
  private var vis: BooleanArray
  private var ans = 0
  fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    vis = BooleanArray(n)
    for (v in restricted) {
      vis[v] = true
    }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    ans = 0
    dfs(0)
    return ans
  }

  private fun dfs(u: Int) {
    if (vis[u]) {
      return
    }
    ++ans
    vis[u] = true
    for (v in g[u]!!) {
      dfs(v)
    }
  }
}
