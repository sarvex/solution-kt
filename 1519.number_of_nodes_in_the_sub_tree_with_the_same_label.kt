class Solution {
  private var g: Array<List<Int>?>
  private var labels: String? = null
  private var ans: IntArray
  private var cnt: IntArray
  fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String?): IntArray {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    this.labels = labels
    ans = IntArray(n)
    cnt = IntArray(26)
    dfs(0, -1)
    return ans
  }

  private fun dfs(i: Int, fa: Int) {
    val k = labels!![i].code - 'a'.code
    ans[i] -= cnt[k]
    cnt[k]++
    for (j in g[i]!!) {
      if (j != fa) {
        dfs(j, i)
      }
    }
    ans[i] += cnt[k]
  }
}
