class Solution {
  fun orangesRotting(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var cnt = 0
    val q: Deque<IntArray> = LinkedList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 2) {
          q.offer(intArrayOf(i, j))
        } else if (grid[i][j] == 1) {
          ++cnt
        }
      }
    }
    var ans = 0
    val dirs = intArrayOf(1, 0, -1, 0, 1)
    while (!q.isEmpty() && cnt > 0) {
      ++ans
      for (i in q.size() downTo 1) {
        val p: IntArray = q.poll()
        for (j in 0..3) {
          val x = p[0] + dirs[j]
          val y = p[1] + dirs[j + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
            grid[x][y] = 2
            --cnt
            q.offer(intArrayOf(x, y))
          }
        }
      }
    }
    return if (cnt > 0) -1 else ans
  }
}
