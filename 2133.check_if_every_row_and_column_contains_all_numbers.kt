internal class Solution {
  fun checkValid(matrix: Array<IntArray>): Boolean {
    val n = matrix.size
    for (i in 0 until n) {
      val seen = BooleanArray(n)
      for (j in 0 until n) {
        val v = matrix[i][j] - 1
        if (seen[v]) {
          return false
        }
        seen[v] = true
      }
    }
    for (j in 0 until n) {
      val seen = BooleanArray(n)
      for (i in 0 until n) {
        val v = matrix[i][j] - 1
        if (seen[v]) {
          return false
        }
        seen[v] = true
      }
    }
    return true
  }
}
