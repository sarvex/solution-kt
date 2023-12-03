internal class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  private val path = StringBuilder()
  fun numDistinctIslands(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    val paths: Set<String> = HashSet()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          dfs(i, j, 0)
          paths.add(path.toString())
          path.setLength(0)
        }
      }
    }
    return paths.size()
  }

  private fun dfs(i: Int, j: Int, k: Int) {
    grid[i][j] = 0
    path.append(k)
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (h in 1..4) {
      val x = i + dirs[h - 1]
      val y = j + dirs[h]
      if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
        dfs(x, y, h)
      }
    }
    path.append(k)
  }
}
