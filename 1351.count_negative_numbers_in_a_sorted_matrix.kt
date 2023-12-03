class Solution {
  fun countNegatives(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var ans = 0
    var i = m - 1
    var j = 0
    while (i >= 0 && j < n) {
      if (grid[i][j] < 0) {
        ans += n - j
        --i
      } else {
        ++j
      }
    }
    return ans
  }
}
