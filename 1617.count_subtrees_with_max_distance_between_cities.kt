class Solution {
  private var g: Array<List<Int>?>
  private var msk = 0
  private var nxt = 0
  private var mx = 0
  fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0] - 1
      val v = e[1] - 1
      g[u].add(v)
      g[v].add(u)
    }
    val ans = IntArray(n - 1)
    for (mask in 1 until (1 shl n)) {
      if (mask and mask - 1 == 0) {
        continue
      }
      msk = mask
      mx = 0
      val cur = 31 - Integer.numberOfLeadingZeros(msk)
      dfs(cur, 0)
      if (msk == 0) {
        msk = mask
        mx = 0
        dfs(nxt, 0)
        ++ans[mx - 1]
      }
    }
    return ans
  }

  private fun dfs(u: Int, d: Int) {
    msk = msk xor (1 shl u)
    if (mx < d) {
      mx = d
      nxt = u
    }
    for (v in g[u]!!) {
      if (msk shr v and 1 == 1) {
        dfs(v, d + 1)
      }
    }
  }
}
