import kotlin.math.abs

class Solution {
  fun differenceOfDistinctValues(grid: Array<IntArray>): Array<IntArray> {
    val m = grid.size
    val n = grid[0].size
    val ans = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        var x = i
        var y = j
        val s: Set<Int> = HashSet()
        while (x > 0 && y > 0) {
          s.add(grid[--x][--y])
        }
        val tl: Int = s.size()
        x = i
        y = j
        s.clear()
        while (x < m - 1 && y < n - 1) {
          s.add(grid[++x][++y])
        }
        val br: Int = s.size()
        ans[i][j] = abs((tl - br).toDouble()).toInt()
      }
    }
    return ans
  }
}
