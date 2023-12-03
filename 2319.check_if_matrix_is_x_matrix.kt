class Solution {
  fun checkXMatrix(grid: Array<IntArray>): Boolean {
    val n = grid.size
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (i == j || i + j == n - 1) {
          if (grid[i][j] == 0) {
            return false
          }
        } else if (grid[i][j] != 0) {
          return false
        }
      }
    }
    return true
  }
}
