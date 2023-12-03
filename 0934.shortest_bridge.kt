class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private val q: Deque<IntArray> = ArrayDeque()
  private var grid: Array<IntArray>
  private var n = 0
  fun shortestBridge(grid: Array<IntArray>): Int {
    this.grid = grid
    n = grid.size
    var i = 0
    var x = 1
    while (i < n && x == 1) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          dfs(i, j)
          x = 0
          break
        }
      }
      ++i
    }
    var ans = 0
    while (true) {
      for (i in q.size() downTo 1) {
        val p: Unit = q.pollFirst()
        for (k in 0..3) {
          val x: Int = p.get(0) + dirs[k]
          val y: Int = p.get(1) + dirs[k + 1]
          if (x >= 0 && x < n && y >= 0 && y < n) {
            if (grid[x][y] == 1) {
              return ans
            }
            if (grid[x][y] == 0) {
              grid[x][y] = 2
              q.offer(intArrayOf(x, y))
            }
          }
        }
      }
      ++ans
    }
  }

  private fun dfs(i: Int, j: Int) {
    grid[i][j] = 2
    q.offer(intArrayOf(i, j))
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
        dfs(x, y)
      }
    }
  }
}
