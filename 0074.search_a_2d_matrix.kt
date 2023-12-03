internal class Solution {
  fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size
    var left = 0
    var right = m * n - 1
    while (left < right) {
      val mid = left + right shr 1
      val x = mid / n
      val y = mid % n
      if (matrix[x][y] >= target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return matrix[left / n][left % n] == target
  }
}
