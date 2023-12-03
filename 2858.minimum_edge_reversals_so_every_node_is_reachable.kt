class Solution {
  private var g: Array<List<IntArray>?>
  private var ans: IntArray
  fun minEdgeReversals(n: Int, edges: Array<IntArray>): IntArray {
    ans = IntArray(n)
    g = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (e in edges) {
      val x = e[0]
      val y = e[1]
      g[x].add(intArrayOf(y, 1))
      g[y].add(intArrayOf(x, -1))
    }
    dfs(0, -1)
    dfs2(0, -1)
    return ans
  }

  private fun dfs(i: Int, fa: Int) {
    for (ne in g[i]!!) {
      val j = ne[0]
      val k = ne[1]
      if (j != fa) {
        ans[0] += if (k < 0) 1 else 0
        dfs(j, i)
      }
    }
  }

  private fun dfs2(i: Int, fa: Int) {
    for (ne in g[i]!!) {
      val j = ne[0]
      val k = ne[1]
      if (j != fa) {
        ans[j] = ans[i] + k
        dfs2(j, i)
      }
    }
  }
}
