import kotlin.math.min

class Solution {
  fun minDistance(houses: IntArray, k: Int): Int {
    Arrays.sort(houses)
    val n = houses.size
    val g = Array(n) { IntArray(n) }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        g[i][j] = g[i + 1][j - 1] + houses[j] - houses[i]
      }
    }
    val f = Array(n) { IntArray(k + 1) }
    val inf = 1 shl 30
    for (e in f) {
      Arrays.fill(e, inf)
    }
    for (i in 0 until n) {
      f[i][1] = g[0][i]
      var j = 2
      while (j <= k && j <= i + 1) {
        for (p in 0 until i) {
          f[i][j] = min(f[i][j].toDouble(), (f[p][j - 1] + g[p + 1][i]).toDouble())
            .toInt()
        }
        ++j
      }
    }
    return f[n - 1][k]
  }
}
