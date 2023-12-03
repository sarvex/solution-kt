import kotlin.math.max

internal class Solution {
  fun makesquare(matchsticks: IntArray): Boolean {
    var s = 0
    var mx = 0
    for (v in matchsticks) {
      s += v
      mx = max(mx.toDouble(), v.toDouble()).toInt()
    }
    val x = s / 4
    val mod = s % 4
    if (mod != 0 || x < mx) {
      return false
    }
    Arrays.sort(matchsticks)
    val edges = IntArray(4)
    return dfs(matchsticks.size - 1, x, matchsticks, edges)
  }

  private fun dfs(u: Int, x: Int, matchsticks: IntArray, edges: IntArray): Boolean {
    if (u < 0) {
      return true
    }
    for (i in 0..3) {
      if (i > 0 && edges[i - 1] == edges[i]) {
        continue
      }
      edges[i] += matchsticks[u]
      if (edges[i] <= x && dfs(u - 1, x, matchsticks, edges)) {
        return true
      }
      edges[i] -= matchsticks[u]
    }
    return false
  }
}
