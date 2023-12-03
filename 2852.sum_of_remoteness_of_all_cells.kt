class Solution {
  private var n = 0
  private var grid: Array<IntArray>
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  fun sumRemoteness(grid: Array<IntArray>): Long {
    n = grid.size
    this.grid = grid
    var cnt = 0
    for (row in grid) {
      for (x in row) {
        if (x > 0) {
          ++cnt
        }
      }
    }
    var ans: Long = 0
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] > 0) {
          val res = dfs(i, j)
          ans += (cnt - res[1]) * res[0]
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): LongArray {
    val res = LongArray(2)
    res[0] = grid[i][j].toLong()
    res[1] = 1
    grid[i][j] = 0
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 0) {
        val tmp = dfs(x, y)
        res[0] += tmp[0]
        res[1] += tmp[1]
      }
    }
    return res
  }
}
