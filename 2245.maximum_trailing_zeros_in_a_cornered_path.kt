import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxTrailingZeros(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val r2 = Array(m + 1) { IntArray(n + 1) }
    val c2 = Array(m + 1) { IntArray(n + 1) }
    val r5 = Array(m + 1) { IntArray(n + 1) }
    val c5 = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        var x = grid[i - 1][j - 1]
        var s2 = 0
        var s5 = 0
        while (x % 2 == 0) {
          ++s2
          x /= 2
        }
        while (x % 5 == 0) {
          ++s5
          x /= 5
        }
        r2[i][j] = r2[i][j - 1] + s2
        c2[i][j] = c2[i - 1][j] + s2
        r5[i][j] = r5[i][j - 1] + s5
        c5[i][j] = c5[i - 1][j] + s5
      }
    }
    var ans = 0
    for (i in 1..m) {
      for (j in 1..n) {
        val a = min((r2[i][j] + c2[i - 1][j]).toDouble(), (r5[i][j] + c5[i - 1][j]).toDouble())
          .toInt()
        val b = min((r2[i][j] + c2[m][j] - c2[i][j]).toDouble(), (r5[i][j] + c5[m][j] - c5[i][j]).toDouble())
          .toInt()
        val c = min((r2[i][n] - r2[i][j] + c2[i][j]).toDouble(), (r5[i][n] - r5[i][j] + c5[i][j]).toDouble())
          .toInt()
        val d = min(
          (r2[i][n] - r2[i][j - 1] + c2[m][j] - c2[i][j]).toDouble(),
          (
              r5[i][n] - r5[i][j - 1] + c5[m][j] - c5[i][j]).toDouble()
        ).toInt()
        ans = max(ans.toDouble(), max(a.toDouble(), max(b.toDouble(), max(c.toDouble(), d.toDouble()))))
          .toInt()
      }
    }
    return ans
  }
}
