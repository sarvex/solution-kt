internal class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  fun shortestPathAllKeys(grid: Array<String>): Int {
    val m = grid.size
    val n = grid[0].length
    var k = 0
    var si = 0
    var sj = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        val c = grid[i][j]
        if (Character.isLowerCase(c)) {
          ++k
        } else if (c == '@') {
          si = i
          sj = j
        }
      }
    }
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(si, sj, 0))
    val vis = Array(m) { Array(n) { BooleanArray(1 shl k) } }
    vis[si][sj][0] = true
    var ans = 0
    while (!q.isEmpty()) {
      for (t in q.size() downTo 1) {
        val p: Unit = q.poll()
        val i: Int = p.get(0)
        val j: Int = p.get(1)
        val state: Int = p.get(2)
        if (state == (1 shl k) - 1) {
          return ans
        }
        for (h in 0..3) {
          val x = i + dirs[h]
          val y = j + dirs[h + 1]
          if (x >= 0 && x < m && y >= 0 && y < n) {
            val c = grid[x][y]
            if (c == '#' || Character.isUpperCase(c) && state shr c.code - 'A'.code and 1 == 0) {
              continue
            }
            var nxt = state
            if (Character.isLowerCase(c)) {
              nxt = nxt or (1 shl c.code - 'a'.code)
            }
            if (!vis[x][y][nxt]) {
              vis[x][y][nxt] = true
              q.offer(intArrayOf(x, y, nxt))
            }
          }
        }
      }
      ++ans
    }
    return -1
  }
}
