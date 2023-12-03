import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun maxDistance(grid: Array<IntArray>): Int {
    val n = grid.size
    val q: Deque<IntArray> = ArrayDeque()
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          q.offer(intArrayOf(i, j))
        }
      }
    }
    var ans = -1
    if (q.isEmpty() || q.size() === n * n) {
      return ans
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      for (i in q.size() downTo 1) {
        val p = q.poll()
        for (k in 0..3) {
          val x = p[0] + dirs[k]
          val y = p[1] + dirs[k + 1]
          if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
            grid[x][y] = 1
            q.offer(intArrayOf(x, y))
          }
        }
      }
      ++ans
    }
    return ans
  }
}
