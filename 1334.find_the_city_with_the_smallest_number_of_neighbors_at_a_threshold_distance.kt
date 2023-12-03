import kotlin.math.min

class Solution {
  fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
    val inf = 1 shl 29
    val g = Array(n) { IntArray(n) }
    for (e in g) {
      Arrays.fill(e, inf)
    }
    for (e in edges) {
      val f = e[0]
      val t = e[1]
      val w = e[2]
      g[f][t] = w
      g[t][f] = w
    }
    for (k in 0 until n) {
      g[k][k] = 0
      for (i in 0 until n) {
        for (j in 0 until n) {
          g[i][j] = min(g[i][j].toDouble(), (g[i][k] + g[k][j]).toDouble())
            .toInt()
        }
      }
    }
    var ans = n
    var cnt = inf
    for (i in n - 1 downTo 0) {
      var t = 0
      for (d in g[i]) {
        if (d <= distanceThreshold) {
          ++t
        }
      }
      if (t < cnt) {
        cnt = t
        ans = i
      }
    }
    return ans
  }
}
