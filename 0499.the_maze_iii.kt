import java.util.Deque

internal class Solution {
  fun findShortestWay(maze: Array<IntArray>, ball: IntArray, hole: IntArray): String {
    val m = maze.size
    val n = maze[0].size
    val r = ball[0]
    val c = ball[1]
    val rh = hole[0]
    val ch = hole[1]
    val q: Deque<IntArray> = LinkedList()
    q.offer(intArrayOf(r, c))
    val dist = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      Arrays.fill(dist[i], Int.MAX_VALUE)
    }
    dist[r][c] = 0
    val path = Array(m) { arrayOfNulls<String>(n) }
    path[r][c] = ""
    val dirs = arrayOf(
      intArrayOf(-1, 0, 'u'.code),
      intArrayOf(1, 0, 'd'.code),
      intArrayOf(0, -1, 'l'.code),
      intArrayOf(0, 1, 'r'.code)
    )
    while (!q.isEmpty()) {
      val p = q.poll()
      val i = p[0]
      val j = p[1]
      for (dir in dirs) {
        val a = dir[0]
        val b = dir[1]
        val d = dir[2].toChar().toString()
        var x = i
        var y = j
        var step = dist[i][j]
        while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0 && (x != rh || y != ch)) {
          x += a
          y += b
          ++step
        }
        if (dist[x][y] > step || dist[x][y] == step && (path[i][j] + d).compareTo(path[x][y]!!) < 0) {
          dist[x][y] = step
          path[x][y] = path[i][j] + d
          if (x != rh || y != ch) {
            q.offer(intArrayOf(x, y))
          }
        }
      }
    }
    return if (path[rh][ch] == null) "impossible" else path[rh][ch]!!
  }
}
