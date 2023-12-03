import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
    val m = maze.size
    val n = maze[0].size
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(entrance)
    maze[entrance[0]][entrance[1]] = '+'
    var ans = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      ++ans
      for (k in q.size() downTo 1) {
        val p = q.poll()
        val i = p[0]
        val j = p[1]
        for (l in 0..3) {
          val x = i + dirs[l]
          val y = j + dirs[l + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.') {
            if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
              return ans
            }
            q.offer(intArrayOf(x, y))
            maze[x][y] = '+'
          }
        }
      }
    }
    return -1
  }
}
