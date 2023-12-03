class Solution {
  fun equalPairs(grid: Array<IntArray>): Int {
    val n = grid.size
    val g = Array(n) { IntArray(n) }
    for (j in 0 until n) {
      for (i in 0 until n) {
        g[i][j] = grid[j][i]
      }
    }
    var ans = 0
    for (row in grid) {
      for (col in g) {
        var ok = 1
        for (i in 0 until n) {
          if (row[i] != col[i]) {
            ok = 0
            break
          }
        }
        ans += ok
      }
    }
    return ans
  }
}
