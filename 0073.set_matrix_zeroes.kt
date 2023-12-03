internal class Solution {
  fun setZeroes(matrix: Array<IntArray>) {
    val m = matrix.size
    val n = matrix[0].size
    var i0 = false
    var j0 = false
    for (j in 0 until n) {
      if (matrix[0][j] == 0) {
        i0 = true
        break
      }
    }
    for (i in 0 until m) {
      if (matrix[i][0] == 0) {
        j0 = true
        break
      }
    }
    for (i in 1 until m) {
      for (j in 1 until n) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0
          matrix[0][j] = 0
        }
      }
    }
    for (i in 1 until m) {
      for (j in 1 until n) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0
        }
      }
    }
    if (i0) {
      for (j in 0 until n) {
        matrix[0][j] = 0
      }
    }
    if (j0) {
      for (i in 0 until m) {
        matrix[i][0] = 0
      }
    }
  }
}
