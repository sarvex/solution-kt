import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun allCellsDistOrder(rows: Int, cols: Int, rCenter: Int, cCenter: Int): Array<IntArray> {
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(rCenter, cCenter))
    val vis = Array(rows) { BooleanArray(cols) }
    vis[rCenter][cCenter] = true
    val ans = Array(rows * cols) { IntArray(2) }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    var idx = 0
    while (!q.isEmpty()) {
      for (n in q.size downTo 1) {
        val p = q.poll()
        ans[idx++] = p
        for (k in 0..3) {
          val x = p[0] + dirs[k]
          val y = p[1] + dirs[k + 1]
          if (x >= 0 && x < rows && y >= 0 && y < cols && !vis[x][y]) {
            vis[x][y] = true
            q.offer(intArrayOf(x, y))
          }
        }
      }
    }
    return ans
  }
}
