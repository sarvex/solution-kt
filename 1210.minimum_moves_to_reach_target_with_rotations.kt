import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  private var n = 0
  private var grid: Array<IntArray>
  private var vis: Array<BooleanArray>
  private val q: Deque<IntArray> = ArrayDeque()
  fun minimumMoves(grid: Array<IntArray>): Int {
    this.grid = grid
    n = grid.size
    vis = Array(n * n) { BooleanArray(2) }
    val target = intArrayOf(n * n - 2, n * n - 1)
    q.offer(intArrayOf(0, 1))
    vis[0][0] = true
    var ans = 0
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val p: Unit = q.poll()
        if (p.get(0) === target[0] && p.get(1) === target[1]) {
          return ans
        }
        val i1: Int = p.get(0) / n
        val j1: Int = p.get(0) % n
        val i2: Int = p.get(1) / n
        val j2: Int = p.get(1) % n
        move(i1, j1 + 1, i2, j2 + 1)
        move(i1 + 1, j1, i2 + 1, j2)
        if (i1 == i2 && i1 + 1 < n && grid[i1 + 1][j2] == 0) {
          move(i1, j1, i1 + 1, j1)
        }
        if (j1 == j2 && j1 + 1 < n && grid[i2][j1 + 1] == 0) {
          move(i1, j1, i1, j1 + 1)
        }
      }
      ++ans
    }
    return -1
  }

  private fun move(i1: Int, j1: Int, i2: Int, j2: Int) {
    if (i1 >= 0 && i1 < n && j1 >= 0 && j1 < n && i2 >= 0 && i2 < n && j2 >= 0 && j2 < n) {
      val a = i1 * n + j1
      val b = i2 * n + j2
      val status = if (i1 == i2) 0 else 1
      if (!vis[a][status] && grid[i1][j1] == 0 && grid[i2][j2] == 0) {
        q.offer(intArrayOf(a, b))
        vis[a][status] = true
      }
    }
  }
}
