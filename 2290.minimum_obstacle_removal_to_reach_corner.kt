class Solution {
  fun minimumObstacles(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0, 0))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    val vis = Array(m) { BooleanArray(n) }
    while (true) {
      val p: Unit = q.poll()
      val i: Int = p.get(0)
      val j: Int = p.get(1)
      val k: Int = p.get(2)
      if (i == m - 1 && j == n - 1) {
        return k
      }
      if (vis[i][j]) {
        continue
      }
      vis[i][j] = true
      for (h in 0..3) {
        val x = i + dirs[h]
        val y = j + dirs[h + 1]
        if (x >= 0 && x < m && y >= 0 && y < n) {
          if (grid[x][y] == 0) {
            q.offerFirst(intArrayOf(x, y, k))
          } else {
            q.offerLast(intArrayOf(x, y, k + 1))
          }
        }
      }
    }
  }
}
