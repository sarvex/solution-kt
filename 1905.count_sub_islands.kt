class Solution {
  fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    val m = grid1.size
    val n = grid1[0].size
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid2[i][j] == 1 && dfs(i, j, m, n, grid1, grid2)) {
          ++ans
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int, m: Int, n: Int, grid1: Array<IntArray>, grid2: Array<IntArray>): Boolean {
    var ans = grid1[i][j] == 1
    grid2[i][j] = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1 && !dfs(x, y, m, n, grid1, grid2)) {
        ans = false
      }
    }
    return ans
  }
}
