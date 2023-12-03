class Solution {
  private var grid: Array<IntArray>
  private var m = 0
  private var n = 0
  fun minDays(grid: Array<IntArray>): Int {
    this.grid = grid
    m = grid.size
    n = grid[0].size
    if (count() != 1) {
      return 0
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          grid[i][j] = 0
          if (count() != 1) {
            return 1
          }
          grid[i][j] = 1
        }
      }
    }
    return 2
  }

  private fun count(): Int {
    var cnt = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          dfs(i, j)
          ++cnt
        }
      }
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 2) {
          grid[i][j] = 1
        }
      }
    }
    return cnt
  }

  private fun dfs(i: Int, j: Int) {
    grid[i][j] = 2
    for (k in 0..3) {
      val x: Int = i + Solution.Companion.DIRS.get(k)
      val y: Int = j + Solution.Companion.DIRS.get(k + 1)
      if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
        dfs(x, y)
      }
    }
  }

  companion object {
    private val DIRS = intArrayOf(-1, 0, 1, 0, -1)
  }
}
