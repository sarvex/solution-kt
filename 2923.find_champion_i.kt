class Solution {
  fun findChampion(grid: Array<IntArray>): Int {
    val n = grid.size
    var i = 0
    while (true) {
      var cnt = 0
      for (j in 0 until n) {
        if (i != j && grid[i][j] == 1) {
          ++cnt
        }
      }
      if (cnt == n - 1) {
        return i
      }
      ++i
    }
  }
}
