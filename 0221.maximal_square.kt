import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maximalSquare(matrix: Array<CharArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    val dp = Array(m + 1) { IntArray(n + 1) }
    var mx = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (matrix[i][j] == '1') {
          dp[i + 1][j + 1] = (min(
            min(dp[i][j + 1].toDouble(), dp[i + 1][j].toDouble()),
            dp[i][j].toDouble()
          ) + 1).toInt()
          mx = max(mx.toDouble(), dp[i + 1][j + 1].toDouble()).toInt()
        }
      }
    }
    return mx * mx
  }
}
