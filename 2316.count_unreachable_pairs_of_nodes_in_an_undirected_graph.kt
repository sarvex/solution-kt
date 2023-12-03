class Solution {
  private var g: Array<List<Int>?>
  private var vis: BooleanArray
  fun countPairs(n: Int, edges: Array<IntArray>): Long {
    g = arrayOfNulls(n)
    vis = BooleanArray(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    var ans: Long = 0
    var s: Long = 0
    for (i in 0 until n) {
      val t = dfs(i)
      ans += s * t
      s += t.toLong()
    }
    return ans
  }

  private fun dfs(i: Int): Int {
    if (vis[i]) {
      return 0
    }
    vis[i] = true
    var cnt = 1
    for (j in g[i]!!) {
      cnt += dfs(j)
    }
    return cnt
  }
}
