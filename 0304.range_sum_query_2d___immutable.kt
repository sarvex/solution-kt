internal class NumMatrix(matrix: Array<IntArray>) {
  private val s: Array<IntArray>

  init {
    val m = matrix.size
    val n = matrix[0].size
    s = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        s[i + 1][j + 1] = s[i + 1][j] + s[i][j + 1] - s[i][j] + matrix[i][j]
      }
    }
  }

  fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
    return s[row2 + 1][col2 + 1] - s[row2 + 1][col1] - s[row1][col2 + 1] + s[row1][col1]
  }
}
