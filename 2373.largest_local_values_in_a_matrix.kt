import kotlin.math.max

class Solution {
  fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    val n = grid.size
    val ans = Array(n - 2) { IntArray(n - 2) }
    for (i in 0 until n - 2) {
      for (j in 0 until n - 2) {
        for (x in i..i + 2) {
          for (y in j..j + 2) {
            ans[i][j] = max(ans[i][j].toDouble(), grid[x][y].toDouble())
              .toInt()
          }
        }
      }
    }
    return ans
  }
}
