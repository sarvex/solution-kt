class Solution {
  fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
    var mat = mat
    val n = mat.size
    for (k in 0..3) {
      val g = Array(n) { IntArray(n) }
      for (i in 0 until n) {
        for (j in 0 until n) {
          g[i][j] = mat[j][n - i - 1]
        }
      }
      if (equals(g, target)) {
        return true
      }
      mat = g
    }
    return false
  }

  private fun equals(a: Array<IntArray>, b: Array<IntArray>): Boolean {
    val n = a.size
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (a[i][j] != b[i][j]) {
          return false
        }
      }
    }
    return true
  }
}
