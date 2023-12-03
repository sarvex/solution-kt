internal class Solution {
  private var g: Array<IntArray>
  private var vis: BooleanArray
  fun findCircleNum(isConnected: Array<IntArray>): Int {
    g = isConnected
    val n = g.size
    vis = BooleanArray(n)
    var ans = 0
    for (i in 0 until n) {
      if (!vis[i]) {
        dfs(i)
        ++ans
      }
    }
    return ans
  }

  private fun dfs(i: Int) {
    vis[i] = true
    for (j in g.indices) {
      if (!vis[j] && g[i][j] == 1) {
        dfs(j)
      }
    }
  }
}
