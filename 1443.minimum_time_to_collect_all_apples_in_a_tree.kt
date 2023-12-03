class Solution {
  fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
    val vis = BooleanArray(n)
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
    }
    return dfs(0, 0, g, hasApple, vis)
  }

  private fun dfs(u: Int, cost: Int, g: Array<List<Int>?>, hasApple: List<Boolean>, vis: BooleanArray): Int {
    if (vis[u]) {
      return 0
    }
    vis[u] = true
    var nxtCost = 0
    for (v in g[u]!!) {
      nxtCost += dfs(v, 2, g, hasApple, vis)
    }
    return if (!hasApple[u] && nxtCost == 0) {
      0
    } else cost + nxtCost
  }
}
