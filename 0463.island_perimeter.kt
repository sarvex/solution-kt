internal class Solution {
  fun islandPerimeter(grid: Array<IntArray>): Int {
    var ans = 0
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          ans += 4
          if (i < m - 1 && grid[i + 1][j] == 1) {
            ans -= 2
          }
          if (j < n - 1 && grid[i][j + 1] == 1) {
            ans -= 2
          }
        }
      }
    }
    return ans
  }
}
