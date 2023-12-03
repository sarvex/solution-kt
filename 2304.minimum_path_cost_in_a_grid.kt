import kotlin.math.min

class Solution {
  fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var f = grid[0]
    val inf = 1 shl 30
    for (i in 1 until m) {
      val g = IntArray(n)
      Arrays.fill(g, inf)
      for (j in 0 until n) {
        for (k in 0 until n) {
          g[j] = min(g[j].toDouble(), (f[k] + moveCost[grid[i - 1][k]][j] + grid[i][j]).toDouble())
            .toInt()
        }
      }
      f = g
    }

    // return Arrays.stream(f).min().getAsInt();
    var ans = inf
    for (v in f) {
      ans = min(ans.toDouble(), v.toDouble()).toInt()
    }
    return ans
  }
}
