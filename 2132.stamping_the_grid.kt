internal class Solution {
  fun possibleToStamp(grid: Array<IntArray>, stampHeight: Int, stampWidth: Int): Boolean {
    val m = grid.size
    val n = grid[0].size
    val s = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        s[i + 1][j + 1] = s[i + 1][j] + s[i][j + 1] - s[i][j] + grid[i][j]
      }
    }
    val d = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 0) {
          val x = i + stampHeight
          val y = j + stampWidth
          if (x <= m && y <= n && s[x][y] - s[x][j] - s[i][y] + s[i][j] == 0) {
            d[i][j]++
            d[i][y]--
            d[x][j]--
            d[x][y]++
          }
        }
      }
    }
    val cnt = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        cnt[i + 1][j + 1] = cnt[i + 1][j] + cnt[i][j + 1] - cnt[i][j] + d[i][j]
        if (grid[i][j] == 0 && cnt[i + 1][j + 1] == 0) {
          return false
        }
      }
    }
    return true
  }
}
