import kotlin.math.max

class Solution {
  fun findColumnWidth(grid: Array<IntArray>): IntArray {
    val n = grid[0].size
    val ans = IntArray(n)
    for (row in grid) {
      for (j in 0 until n) {
        val w = row[j].toString().length
        ans[j] = max(ans[j].toDouble(), w.toDouble()).toInt()
      }
    }
    return ans
  }
}
