import kotlin.math.min

class Solution {
  private var g: Array<List<IntArray>?>
  private var vis: BooleanArray
  private var ans = 1 shl 30
  fun minScore(n: Int, roads: Array<IntArray>): Int {
    g = arrayOfNulls(n)
    vis = BooleanArray(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in roads) {
      val a = e[0] - 1
      val b = e[1] - 1
      val d = e[2]
      g[a].add(intArrayOf(b, d))
      g[b].add(intArrayOf(a, d))
    }
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    for (nxt in g[i]!!) {
      val j = nxt[0]
      val d = nxt[1]
      ans = min(ans.toDouble(), d.toDouble()).toInt()
      if (!vis[j]) {
        vis[j] = true
        dfs(j)
      }
    }
  }
}
