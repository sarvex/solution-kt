import kotlin.math.min

class Solution {
  private var rowsum: Array<IntArray>
  private var colsum: Array<IntArray>
  fun largestMagicSquare(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    rowsum = Array(m + 1) { IntArray(n + 1) }
    colsum = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        rowsum[i][j] = rowsum[i][j - 1] + grid[i - 1][j - 1]
        colsum[i][j] = colsum[i - 1][j] + grid[i - 1][j - 1]
      }
    }
    for (k in min(m.toDouble(), n.toDouble()) downTo 2) {
      var i = 0
      while (i + k - 1 < m) {
        var j = 0
        while (j + k - 1 < n) {
          val i2: Int = i + k - 1
          val j2: Int = j + k - 1
          if (check(grid, i, j, i2, j2)) {
            return k
          }
          ++j
        }
        ++i
      }
    }
    return 1
  }

  private fun check(grid: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val `val` = rowsum[x1 + 1][y2 + 1] - rowsum[x1 + 1][y1]
    for (i in x1 + 1..x2) {
      if (rowsum[i + 1][y2 + 1] - rowsum[i + 1][y1] != `val`) {
        return false
      }
    }
    for (j in y1..y2) {
      if (colsum[x2 + 1][j + 1] - colsum[x1][j + 1] != `val`) {
        return false
      }
    }
    var s = 0
    run {
      var i = x1
      var j = y1
      while (i <= x2) {
        s += grid[i][j]
        ++i
        ++j
      }
    }
    if (s != `val`) {
      return false
    }
    s = 0
    var i = x1
    var j = y2
    while (i <= x2) {
      s += grid[i][j]
      ++i
      --j
    }
    return if (s != `val`) {
      false
    } else true
  }
}
