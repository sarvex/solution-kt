import java.util.*
import kotlin.math.min

internal class Solution {
  fun shortestDistance(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val q: Deque<IntArray> = LinkedList()
    var total = 0
    val cnt = Array(m) { IntArray(n) }
    val dist = Array(m) { IntArray(n) }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          ++total
          q.offer(intArrayOf(i, j))
          var d = 0
          val vis = Array(m) { BooleanArray(n) }
          while (!q.isEmpty()) {
            ++d
            for (k in q.size() downTo 1) {
              val p = q.poll()
              for (l in 0..3) {
                val x = p[0] + dirs[l]
                val y = p[1] + dirs[l + 1]
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !vis[x][y]) {
                  ++cnt[x][y]
                  dist[x][y] += d
                  q.offer(intArrayOf(x, y))
                  vis[x][y] = true
                }
              }
            }
          }
        }
      }
    }
    var ans = Int.MAX_VALUE
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 0 && cnt[i][j] == total) {
          ans = min(ans.toDouble(), dist[i][j].toDouble()).toInt()
        }
      }
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
  }
}
