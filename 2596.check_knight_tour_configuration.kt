import kotlin.math.abs

class Solution {
  fun checkValidGrid(grid: Array<IntArray>): Boolean {
    if (grid[0][0] != 0) {
      return false
    }
    val n = grid.size
    val pos = Array(n * n) { IntArray(2) }
    for (i in 0 until n) {
      for (j in 0 until n) {
        pos[grid[i][j]] = intArrayOf(i, j)
      }
    }
    for (i in 1 until n * n) {
      val p1 = pos[i - 1]
      val p2 = pos[i]
      val dx = abs((p1[0] - p2[0]).toDouble()).toInt()
      val dy = abs((p1[1] - p2[1]).toDouble()).toInt()
      val ok = dx == 1 && dy == 2 || dx == 2 && dy == 1
      if (!ok) {
        return false
      }
    }
    return true
  }
}
