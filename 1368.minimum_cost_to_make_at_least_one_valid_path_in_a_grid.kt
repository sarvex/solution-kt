import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun minCost(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val vis = Array(m) { BooleanArray(n) }
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0, 0))
    val dirs = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    while (!q.isEmpty()) {
      val p = q.poll()
      val i = p[0]
      val j = p[1]
      val d = p[2]
      if (i == m - 1 && j == n - 1) {
        return d
      }
      if (vis[i][j]) {
        continue
      }
      vis[i][j] = true
      for (k in 1..4) {
        val x = i + dirs[k][0]
        val y = j + dirs[k][1]
        if (x >= 0 && x < m && y >= 0 && y < n) {
          if (grid[i][j] == k) {
            q.offerFirst(intArrayOf(x, y, d))
          } else {
            q.offer(intArrayOf(x, y, d + 1))
          }
        }
      }
    }
    return -1
  }
}
