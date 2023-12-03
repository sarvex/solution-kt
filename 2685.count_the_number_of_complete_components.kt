class Solution {
  private var g: Array<List<Int>?>
  private var vis: BooleanArray
  fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
    g = arrayOfNulls(n)
    vis = BooleanArray(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    var ans = 0
    for (i in 0 until n) {
      if (!vis[i]) {
        val t = dfs(i)
        if (t[0] * (t[0] - 1) == t[1]) {
          ++ans
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int): IntArray {
    vis[i] = true
    var x = 1
    var y: Int = g[i]!!.size()
    for (j in g[i]!!) {
      if (!vis[j]) {
        val t = dfs(j)
        x += t[0]
        y += t[1]
      }
    }
    return intArrayOf(x, y)
  }
}
