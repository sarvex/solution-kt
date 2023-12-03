import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun shortestPath(grid: Array<IntArray>, k: Int): Int {
    var k = k
    val m = grid.size
    val n = grid[0].size
    if (k >= m + n - 3) {
      return m + n - 2
    }
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0, k))
    val vis = Array(m) { Array(n) { BooleanArray(k + 1) } }
    vis[0][0][k] = true
    var ans = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      ++ans
      for (i in q.size() downTo 1) {
        val p = q.poll()
        k = p[2]
        for (j in 0..3) {
          val x = p[0] + dirs[j]
          val y = p[1] + dirs[j + 1]
          if (x >= 0 && x < m && y >= 0 && y < n) {
            if (x == m - 1 && y == n - 1) {
              return ans
            }
            if (grid[x][y] == 0 && !vis[x][y][k]) {
              q.offer(intArrayOf(x, y, k))
              vis[x][y][k] = true
            } else if (grid[x][y] == 1 && k > 0 && !vis[x][y][k - 1]) {
              q.offer(intArrayOf(x, y, k - 1))
              vis[x][y][k - 1] = true
            }
          }
        }
      }
    }
    return -1
  }
}
