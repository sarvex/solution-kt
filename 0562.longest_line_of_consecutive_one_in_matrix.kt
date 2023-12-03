internal class Solution {
  fun longestLine(mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    val a = Array(m + 2) { IntArray(n + 2) }
    val b = Array(m + 2) { IntArray(n + 2) }
    val c = Array(m + 2) { IntArray(n + 2) }
    val d = Array(m + 2) { IntArray(n + 2) }
    var ans = 0
    for (i in 1..m) {
      for (j in 1..n) {
        if (mat[i - 1][j - 1] == 1) {
          a[i][j] = a[i - 1][j] + 1
          b[i][j] = b[i][j - 1] + 1
          c[i][j] = c[i - 1][j - 1] + 1
          d[i][j] = d[i - 1][j + 1] + 1
          ans = max(ans, a[i][j], b[i][j], c[i][j], d[i][j])
        }
      }
    }
    return ans
  }

  private fun max(vararg arr: Int): Int {
    var ans = 0
    for (v in arr) {
      ans = kotlin.math.max(ans.toDouble(), v.toDouble()).toInt()
    }
    return ans
  }
}
