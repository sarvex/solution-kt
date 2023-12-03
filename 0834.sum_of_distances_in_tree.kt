internal class Solution {
  private var n = 0
  private var ans: IntArray
  private var size: IntArray
  private var g: Array<List<Int>?>
  fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
    this.n = n
    g = arrayOfNulls(n)
    ans = IntArray(n)
    size = IntArray(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    dfs1(0, -1, 0)
    dfs2(0, -1, ans[0])
    return ans
  }

  private fun dfs1(i: Int, fa: Int, d: Int) {
    ans[0] += d
    size[i] = 1
    for (j in g[i]!!) {
      if (j != fa) {
        dfs1(j, i, d + 1)
        size[i] += size[j]
      }
    }
  }

  private fun dfs2(i: Int, fa: Int, t: Int) {
    ans[i] = t
    for (j in g[i]!!) {
      if (j != fa) {
        dfs2(j, i, t - size[j] + n - size[j])
      }
    }
  }
}
