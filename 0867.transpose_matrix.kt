internal class Solution {
  fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val m = matrix.size
    val n = matrix[0].size
    val ans = Array(n) { IntArray(m) }
    for (i in 0 until n) {
      for (j in 0 until m) {
        ans[i][j] = matrix[j][i]
      }
    }
    return ans
  }
}
