import kotlin.math.min

class Solution {
  fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    for (k in 0 until (min(m.toDouble(), n.toDouble()) - 1).toInt()) {
      for (i in 0 until m - 1) {
        for (j in 0 until n - 1) {
          if (mat[i][j] > mat[i + 1][j + 1]) {
            val t = mat[i][j]
            mat[i][j] = mat[i + 1][j + 1]
            mat[i + 1][j + 1] = t
          }
        }
      }
    }
    return mat
  }
}
