internal class Solution {
  fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size
    var i = m - 1
    var j = 0
    while (i >= 0 && j < n) {
      if (matrix[i][j] == target) {
        return true
      }
      if (matrix[i][j] > target) {
        --i
      } else {
        ++j
      }
    }
    return false
  }
}
