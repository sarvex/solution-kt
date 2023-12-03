import kotlin.math.max

class Solution {
  fun largestSubmatrix(matrix: Array<IntArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    for (i in 1 until m) {
      for (j in 0 until n) {
        if (matrix[i][j] == 1) {
          matrix[i][j] = matrix[i - 1][j] + 1
        }
      }
    }
    var ans = 0
    for (row in matrix) {
      Arrays.sort(row)
      var j = n - 1
      var k = 1
      while (j >= 0 && row[j] > 0) {
        val s = row[j] * k
        ans = max(ans.toDouble(), s.toDouble()).toInt()
        --j
        ++k
      }
    }
    return ans
  }
}
