class Solution {
  private var g: Array<List<Int>?>
  private val gs: Map<Long, Int> = HashMap()
  private var ans = 0
  private var k = 0
  private var cnt = 0
  private var n = 0
  fun rootCount(edges: Array<IntArray>, guesses: Array<IntArray>, k: Int): Int {
    this.k = k
    n = edges.size + 1
    g = arrayOfNulls(n)
    Arrays.setAll(g) { e -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    for (e in guesses) {
      val a = e[0]
      val b = e[1]
      gs.merge(f(a, b), 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    dfs1(0, -1)
    dfs2(0, -1)
    return ans
  }

  private fun dfs1(i: Int, fa: Int) {
    for (j in g[i]!!) {
      if (j != fa) {
        cnt += gs[f(i, j)] ?: 0
        dfs1(j, i)
      }
    }
  }

  private fun dfs2(i: Int, fa: Int) {
    ans += if (cnt >= k) 1 else 0
    for (j in g[i]!!) {
      if (j != fa) {
        val a = gs[f(i, j)] ?: 0
        val b = gs[f(j, i)] ?: 0
        cnt -= a
        cnt += b
        dfs2(j, i)
        cnt -= b
        cnt += a
      }
    }
  }

  private fun f(i: Int, j: Int): Long {
    return 1L * i * n + j
  }
}
