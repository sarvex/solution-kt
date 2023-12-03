import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    if (grid[0][0] == 1) {
      return -1
    }
    val n = grid.size
    grid[0][0] = 1
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0))
    var ans = 1
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val p: Unit = q.poll()
        val i: Int = p.get(0)
        val j: Int = p.get(1)
        if (i == n - 1 && j == n - 1) {
          return ans
        }
        for (x in i - 1..i + 1) {
          for (y in j - 1..j + 1) {
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
              grid[x][y] = 1
              q.offer(intArrayOf(x, y))
            }
          }
        }
      }
      ++ans
    }
    return -1
  }
}
