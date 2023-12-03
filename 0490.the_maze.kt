import java.util.*

internal class Solution {
  fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
    val m = maze.size
    val n = maze[0].size
    val vis = Array(m) { BooleanArray(n) }
    vis[start[0]][start[1]] = true
    val q: Deque<IntArray> = LinkedList()
    q.offer(start)
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val p = q.poll()
      val i = p[0]
      val j = p[1]
      for (k in 0..3) {
        var x = i
        var y = j
        val a = dirs[k]
        val b = dirs[k + 1]
        while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0) {
          x += a
          y += b
        }
        if (x == destination[0] && y == destination[1]) {
          return true
        }
        if (!vis[x][y]) {
          vis[x][y] = true
          q.offer(intArrayOf(x, y))
        }
      }
    }
    return false
  }
}
