class Solution {
  fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
    val mat = Array(n) { IntArray(n) }
    for (q in queries) {
      val x1 = q[0]
      val y1 = q[1]
      val x2 = q[2]
      val y2 = q[3]
      mat[x1][y1]++
      if (x2 + 1 < n) {
        mat[x2 + 1][y1]--
      }
      if (y2 + 1 < n) {
        mat[x1][y2 + 1]--
      }
      if (x2 + 1 < n && y2 + 1 < n) {
        mat[x2 + 1][y2 + 1]++
      }
    }
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (i > 0) {
          mat[i][j] += mat[i - 1][j]
        }
        if (j > 0) {
          mat[i][j] += mat[i][j - 1]
        }
        if (i > 0 && j > 0) {
          mat[i][j] -= mat[i - 1][j - 1]
        }
      }
    }
    return mat
  }
}
