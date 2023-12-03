import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val g = Array<IntArray>(Solution.Companion.N) { IntArray(Solution.Companion.N) }
    for (i in 0 until Solution.Companion.N) {
      Arrays.fill(g[i], Solution.Companion.INF)
    }
    for (e in times) {
      g[e[0]][e[1]] = e[2]
    }
    val dist = IntArray(Solution.Companion.N)
    Arrays.fill(dist, Solution.Companion.INF)
    dist[k] = 0
    val vis = BooleanArray(Solution.Companion.N)
    for (i in 0 until n) {
      var t = -1
      for (j in 1..n) {
        if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
          t = j
        }
      }
      vis[t] = true
      for (j in 1..n) {
        dist[j] = min(dist[j].toDouble(), (dist[t] + g[t][j]).toDouble()).toInt()
      }
    }
    var ans = 0
    for (i in 1..n) {
      ans = max(ans.toDouble(), dist[i].toDouble()).toInt()
    }
    return if (ans == Solution.Companion.INF) -1 else ans
  }

  companion object {
    private const val N = 110
    private const val INF = 0x3f3f
  }
}
