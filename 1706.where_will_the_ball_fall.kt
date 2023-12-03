class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  fun findBall(grid: Array<IntArray>): IntArray {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    val ans = IntArray(n)
    for (j in 0 until n) {
      ans[j] = dfs(0, j)
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i == m) {
      return j
    }
    if (j == 0 && grid[i][j] == -1) {
      return -1
    }
    if (j == n - 1 && grid[i][j] == 1) {
      return -1
    }
    if (grid[i][j] == 1 && grid[i][j + 1] == -1) {
      return -1
    }
    if (grid[i][j] == -1 && grid[i][j - 1] == 1) {
      return -1
    }
    return if (grid[i][j] == 1) dfs(i + 1, j + 1) else dfs(i + 1, j - 1)
  }
}
