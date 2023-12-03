class Solution {
  private var grid: Array<IntArray>
  private var fire: Array<BooleanArray>
  private var vis: Array<BooleanArray>
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private var m = 0
  private var n = 0
  fun maximumMinutes(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    fire = Array(m) { BooleanArray(n) }
    vis = Array(m) { BooleanArray(n) }
    var l = -1
    var r = m * n
    while (l < r) {
      val mid = l + r + 1 shr 1
      if (check(mid)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return if (l == m * n) 1000000000 else l
  }

  private fun check(t: Int): Boolean {
    var t = t
    for (i in 0 until m) {
      Arrays.fill(fire[i], false)
      Arrays.fill(vis[i], false)
    }
    var q1: Deque<IntArray> = ArrayDeque()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          q1.offer(intArrayOf(i, j))
          fire[i][j] = true
        }
      }
    }
    while (t > 0 && !q1.isEmpty()) {
      q1 = spread(q1)
      --t
    }
    if (fire[0][0]) {
      return false
    }
    val q2: Deque<IntArray> = ArrayDeque()
    q2.offer(intArrayOf(0, 0))
    vis[0][0] = true
    while (!q2.isEmpty()) {
      for (d in q2.size() downTo 1) {
        val p: IntArray = q2.poll()
        if (fire[p[0]][p[1]]) {
          continue
        }
        for (k in 0..3) {
          val x = p[0] + dirs[k]
          val y = p[1] + dirs[k + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && !fire[x][y] && !vis[x][y] && grid[x][y] == 0) {
            if (x == m - 1 && y == n - 1) {
              return true
            }
            vis[x][y] = true
            q2.offer(intArrayOf(x, y))
          }
        }
      }
      q1 = spread(q1)
    }
    return false
  }

  private fun spread(q: Deque<IntArray>): Deque<IntArray> {
    val nq: Deque<IntArray> = ArrayDeque()
    while (!q.isEmpty()) {
      val p: IntArray = q.poll()
      for (k in 0..3) {
        val x = p[0] + dirs[k]
        val y = p[1] + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && !fire[x][y] && grid[x][y] == 0) {
          fire[x][y] = true
          nq.offer(intArrayOf(x, y))
        }
      }
    }
    return nq
  }
}
