import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<CharArray>
  fun minPushBox(grid: Array<CharArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    var si = 0
    var sj = 0
    var bi = 0
    var bj = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 'S') {
          si = i
          sj = j
        } else if (grid[i][j] == 'B') {
          bi = i
          bj = j
        }
      }
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    val q: Deque<IntArray> = ArrayDeque()
    val vis = Array(m * n) { BooleanArray(m * n) }
    q.offer(intArrayOf(f(si, sj), f(bi, bj), 0))
    vis[f(si, sj)][f(bi, bj)] = true
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val d: Int = p.get(2)
      bi = p.get(1) / n
      bj = p.get(1) % n
      if (grid[bi][bj] == 'T') {
        return d
      }
      si = p.get(0) / n
      sj = p.get(0) % n
      for (k in 0..3) {
        val sx = si + dirs[k]
        val sy = sj + dirs[k + 1]
        if (!check(sx, sy)) {
          continue
        }
        if (sx == bi && sy == bj) {
          val bx = bi + dirs[k]
          val by = bj + dirs[k + 1]
          if (!check(bx, by) || vis[f(sx, sy)][f(bx, by)]) {
            continue
          }
          vis[f(sx, sy)][f(bx, by)] = true
          q.offer(intArrayOf(f(sx, sy), f(bx, by), d + 1))
        } else if (!vis[f(sx, sy)][f(bi, bj)]) {
          vis[f(sx, sy)][f(bi, bj)] = true
          q.offerFirst(intArrayOf(f(sx, sy), f(bi, bj), d))
        }
      }
    }
    return -1
  }

  private fun f(i: Int, j: Int): Int {
    return i * n + j
  }

  private fun check(i: Int, j: Int): Boolean {
    return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != '#'
  }
}
