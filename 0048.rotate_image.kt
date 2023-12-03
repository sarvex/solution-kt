internal class Solution {
  fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size
    for (i in 0 until (n shr 1)) {
      for (j in 0 until n) {
        val t = matrix[i][j]
        matrix[i][j] = matrix[n - i - 1][j]
        matrix[n - i - 1][j] = t
      }
    }
    for (i in 0 until n) {
      for (j in 0 until i) {
        val t = matrix[i][j]
        matrix[i][j] = matrix[j][i]
        matrix[j][i] = t
      }
    }
  }
}
