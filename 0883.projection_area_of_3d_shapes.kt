import kotlin.math.max

internal class Solution {
  fun projectionArea(grid: Array<IntArray>): Int {
    var xy = 0
    var yz = 0
    var zx = 0
    var i = 0
    val n = grid.size
    while (i < n) {
      var maxYz = 0
      var maxZx = 0
      for (j in 0 until n) {
        if (grid[i][j] > 0) {
          ++xy
        }
        maxYz = max(maxYz.toDouble(), grid[i][j].toDouble()).toInt()
        maxZx = max(maxZx.toDouble(), grid[j][i].toDouble()).toInt()
      }
      yz += maxYz
      zx += maxZx
      ++i
    }
    return xy + yz + zx
  }
}
