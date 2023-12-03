import kotlin.math.max

class Solution {
  fun maxMoves(grid: Array<IntArray>): Int {
    val dirs = arrayOf(intArrayOf(-1, 1), intArrayOf(0, 1), intArrayOf(1, 1))
    val m = grid.size
    val n = grid[0].size
    val q: Deque<IntArray> = ArrayDeque()
    for (i in 0 until m) {
      q.offer(intArrayOf(i, 0))
    }
    val dist = Array(m) { IntArray(n) }
    var ans = 0
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val i: Int = p.get(0)
      val j: Int = p.get(1)
      for (dir in dirs) {
        val x = i + dir[0]
        val y = j + dir[1]
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[i][j] && dist[x][y] < dist[i][j] + 1) {
          dist[x][y] = dist[i][j] + 1
          ans = max(ans.toDouble(), dist[x][y].toDouble()).toInt()
          q.offer(intArrayOf(x, y))
        }
      }
    }
    return ans
  }
}
