import java.util.*

internal class Solution {
  fun wallsAndGates(rooms: Array<IntArray>) {
    val m = rooms.size
    val n = rooms[0].size
    val q: Deque<IntArray> = LinkedList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (rooms[i][j] == 0) {
          q.offer(intArrayOf(i, j))
        }
      }
    }
    var d = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      ++d
      for (i in q.size() downTo 1) {
        val p = q.poll()
        for (j in 0..3) {
          val x = p[0] + dirs[j]
          val y = p[1] + dirs[j + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Int.MAX_VALUE) {
            rooms[x][y] = d
            q.offer(intArrayOf(x, y))
          }
        }
      }
    }
  }
}
