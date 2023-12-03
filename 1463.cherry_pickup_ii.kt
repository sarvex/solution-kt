import kotlin.math.max

class Solution {
  fun cherryPickup(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var f = Array(n) { IntArray(n) }
    var g = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      Arrays.fill(f[i], -1)
      Arrays.fill(g[i], -1)
    }
    f[0][n - 1] = grid[0][0] + grid[0][n - 1]
    for (i in 1 until m) {
      for (j1 in 0 until n) {
        for (j2 in 0 until n) {
          val x = grid[i][j1] + if (j1 == j2) 0 else grid[i][j2]
          for (y1 in j1 - 1..j1 + 1) {
            for (y2 in j2 - 1..j2 + 1) {
              if (y1 >= 0 && y1 < n && y2 >= 0 && y2 < n && f[y1][y2] != -1) {
                g[j1][j2] = max(g[j1][j2].toDouble(), (f[y1][y2] + x).toDouble())
                  .toInt()
              }
            }
          }
        }
      }
      val t = f
      f = g
      g = t
    }
    var ans = 0
    for (j1 in 0 until n) {
      for (j2 in 0 until n) {
        ans = max(ans.toDouble(), f[j1][j2].toDouble()).toInt()
      }
    }
    return ans
  }
}
