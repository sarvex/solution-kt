class Solution {
  private var ans = 0
  private var g: Array<List<Int>?>
  private var values: IntArray
  private var k = 0
  fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    this.values = values
    this.k = k
    dfs(0, -1)
    return ans
  }

  private fun dfs(i: Int, fa: Int): Long {
    var s = values[i].toLong()
    for (j in g[i]!!) {
      if (j != fa) {
        s += dfs(j, i)
      }
    }
    ans += if (s % k == 0L) 1 else 0
    return s
  }
}
