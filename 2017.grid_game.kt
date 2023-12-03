import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun gridGame(grid: Array<IntArray>): Long {
    var ans = Long.MAX_VALUE
    var s1: Long = 0
    var s2: Long = 0
    for (v in grid[0]) {
      s1 += v.toLong()
    }
    val n = grid[0].size
    for (j in 0 until n) {
      s1 -= grid[0][j].toLong()
      ans = min(ans.toDouble(), max(s1.toDouble(), s2.toDouble())).toLong()
      s2 += grid[1][j].toLong()
    }
    return ans
  }
}
