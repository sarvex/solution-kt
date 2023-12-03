import kotlin.math.min

class Solution {
  fun minTrioDegree(n: Int, edges: Array<IntArray>): Int {
    val g = Array(n) { BooleanArray(n) }
    val deg = IntArray(n)
    for (e in edges) {
      val u = e[0] - 1
      val v = e[1] - 1
      g[u][v] = true
      g[v][u] = true
      ++deg[u]
      ++deg[v]
    }
    var ans = 1 shl 30
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        if (g[i][j]) {
          for (k in j + 1 until n) {
            if (g[i][k] && g[j][k]) {
              ans = min(ans.toDouble(), (deg[i] + deg[j] + deg[k] - 6).toDouble())
                .toInt()
            }
          }
        }
      }
    }
    return if (ans == 1 shl 30) -1 else ans
  }
}
