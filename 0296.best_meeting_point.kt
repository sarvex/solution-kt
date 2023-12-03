import kotlin.math.abs

internal class Solution {
  fun minTotalDistance(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val rows: List<Int> = ArrayList()
    val cols: List<Int> = ArrayList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          rows.add(i)
          cols.add(j)
        }
      }
    }
    Collections.sort(cols)
    val i = rows[rows.size() shr 1]
    val j = cols[cols.size() shr 1]
    return f(rows, i) + f(cols, j)
  }

  private fun f(arr: List<Int>, x: Int): Int {
    var s = 0
    for (v in arr) {
      (s += abs((v - x).toDouble())).toInt()
    }
    return s
  }
}
