import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  fun getFood(grid: Array<CharArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val q: Deque<IntArray> = ArrayDeque()
    var i = 0
    var x = 1
    while (i < m && x == 1) {
      for (j in 0 until n) {
        if (grid[i][j] == '*') {
          q.offer(intArrayOf(i, j))
          x = 0
          break
        }
      }
      ++i
    }
    var ans = 0
    while (!q.isEmpty()) {
      ++ans
      for (t in q.size() downTo 1) {
        val p: Unit = q.poll()
        for (k in 0..3) {
          val x: Int = p.get(0) + dirs[k]
          val y: Int = p.get(1) + dirs[k + 1]
          if (x >= 0 && x < m && y >= 0 && y < n) {
            if (grid[x][y] == '#') {
              return ans
            }
            if (grid[x][y] == 'O') {
              grid[x][y] = 'X'
              q.offer(intArrayOf(x, y))
            }
          }
        }
      }
    }
    return -1
  }
}
