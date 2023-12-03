import kotlin.math.min

class Solution {
  fun numSubmat(mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    val g = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (mat[i][j] == 1) {
          g[i][j] = if (j == 0) 1 else 1 + g[i][j - 1]
        }
      }
    }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        var col = 1 shl 30
        var k = i
        while (k >= 0 && col > 0) {
          col = min(col.toDouble(), g[k][j].toDouble()).toInt()
          ans += col
          --k
        }
      }
    }
    return ans
  }
}
