internal class Solution {
  fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    val n = matrix.size
    var left = matrix[0][0]
    var right = matrix[n - 1][n - 1]
    while (left < right) {
      val mid = left + right ushr 1
      if (check(matrix, mid, k, n)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun check(matrix: Array<IntArray>, mid: Int, k: Int, n: Int): Boolean {
    var count = 0
    var i = n - 1
    var j = 0
    while (i >= 0 && j < n) {
      if (matrix[i][j] <= mid) {
        count += i + 1
        ++j
      } else {
        --i
      }
    }
    return count >= k
  }
}
