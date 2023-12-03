import kotlin.math.min

internal class Solution {
  fun minimumMoves(arr: IntArray): Int {
    val n = arr.size
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][i] = 1
    }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        if (i + 1 == j) {
          f[i][j] = if (arr[i] == arr[j]) 1 else 2
        } else {
          var t = if (arr[i] == arr[j]) f[i + 1][j - 1] else 1 shl 30
          for (k in i until j) {
            t = min(t.toDouble(), (f[i][k] + f[k + 1][j]).toDouble()).toInt()
          }
          f[i][j] = t
        }
      }
    }
    return f[0][n - 1]
  }
}
