import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val rmx = IntArray(m)
    val cmx = IntArray(n)
    for (i in 0 until m) {
      for (j in 0 until n) {
        rmx[i] = max(rmx[i].toDouble(), grid[i][j].toDouble()).toInt()
        cmx[j] = max(cmx[j].toDouble(), grid[i][j].toDouble()).toInt()
      }
    }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        (ans += min(rmx[i].toDouble(), cmx[j].toDouble()) - grid[i][j]).toInt()
      }
    }
    return ans
  }
}
