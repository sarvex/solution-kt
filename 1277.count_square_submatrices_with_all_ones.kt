import kotlin.math.min

internal class Solution {
  fun countSquares(matrix: Array<IntArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    val f = Array(m) { IntArray(n) }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (matrix[i][j] == 0) {
          continue
        }
        if (i == 0 || j == 0) {
          f[i][j] = 1
        } else {
          f[i][j] = (min(
            f[i - 1][j - 1].toDouble(),
            min(f[i - 1][j].toDouble(), f[i][j - 1].toDouble())
          ) + 1).toInt()
        }
        ans += f[i][j]
      }
    }
    return ans
  }
}
