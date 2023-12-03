import kotlin.math.max

class Solution {
  fun countVisitedNodes(edges: List<Int>): IntArray {
    val n: Int = edges.size()
    val ans = IntArray(n)
    val vis = IntArray(n)
    for (i in 0 until n) {
      if (ans[i] == 0) {
        var cnt = 0
        var j = i
        while (vis[j] == 0) {
          vis[j] = ++cnt
          j = edges[j]
        }
        var cycle = 0
        var total = cnt + ans[j]
        if (ans[j] == 0) {
          cycle = cnt - vis[j] + 1
        }
        j = i
        while (ans[j] == 0) {
          ans[j] = max(total--.toDouble(), cycle.toDouble()).toInt()
          j = edges[j]
        }
      }
    }
    return ans
  }
}
