internal class Solution {
  fun countServers(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val row = IntArray(m)
    val col = IntArray(n)
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          row[i]++
          col[j]++
        }
      }
    }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
          ++ans
        }
      }
    }
    return ans
  }
}
