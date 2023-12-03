import kotlin.math.min

class Solution {
  private var m = 0
  private var n = 0
  private var threshold = 0
  private var s: Array<IntArray>
  fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
    m = mat.size
    n = mat[0].size
    this.threshold = threshold
    s = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + mat[i - 1][j - 1]
      }
    }
    var l = 0
    var r = min(m.toDouble(), n.toDouble()).toInt()
    while (l < r) {
      val mid = l + r + 1 shr 1
      if (check(mid)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }

  private fun check(k: Int): Boolean {
    for (i in 0 until m - k + 1) {
      for (j in 0 until n - k + 1) {
        if (s[i + k][j + k] - s[i][j + k] - s[i + k][j] + s[i][j] <= threshold) {
          return true
        }
      }
    }
    return false
  }
}
