class Solution {
  private var g: Array<List<Int>?>
  private var f: IntArray
  private var vis: BooleanArray
  private var k = 0
  fun leadsToDestination(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    vis = BooleanArray(n)
    g = arrayOfNulls(n)
    k = destination
    f = IntArray(n)
    Arrays.setAll(g) { key -> ArrayList() }
    for (e in edges) {
      g[e[0]].add(e[1])
    }
    return dfs(source)
  }

  private fun dfs(i: Int): Boolean {
    if (i == k) {
      return g[i]!!.isEmpty()
    }
    if (f[i] != 0) {
      return f[i] == 1
    }
    if (vis[i] || g[i]!!.isEmpty()) {
      return false
    }
    vis[i] = true
    for (j in g[i]!!) {
      if (!dfs(j)) {
        f[i] = -1
        return false
      }
    }
    f[i] = 1
    return true
  }
}
