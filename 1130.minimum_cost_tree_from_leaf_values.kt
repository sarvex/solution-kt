import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun mctFromLeafValues(arr: IntArray): Int {
    val n = arr.size
    val f = Array(n) { IntArray(n) }
    val g = Array(n) { IntArray(n) }
    for (i in n - 1 downTo 0) {
      g[i][i] = arr[i]
      for (j in i + 1 until n) {
        g[i][j] = max(g[i][j - 1].toDouble(), arr[j].toDouble()).toInt()
        f[i][j] = 1 shl 30
        for (k in i until j) {
          f[i][j] = min(
            f[i][j].toDouble(),
            (f[i][k] + f[k + 1][j] + g[i][k] * g[k + 1][j]).toDouble()
          ).toInt()
        }
      }
    }
    return f[0][n - 1]
  }
}
