internal class Solution {
  fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
    val m = maze.size
    val n = maze[0].size
    val inf = 1 shl 30
    val dist = Array(m) { IntArray(n) }
    for (row in dist) {
      Arrays.fill(row, inf)
    }
    val si = start[0]
    val sj = start[1]
    val di = destination[0]
    val dj = destination[1]
    dist[si][sj] = 0
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(si, sj))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val i: Int = p.get(0)
      val j: Int = p.get(1)
      for (d in 0..3) {
        var x = i
        var y = j
        var k = dist[i][j]
        val a = dirs[d]
        val b = dirs[d + 1]
        while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0) {
          x += a
          y += b
          ++k
        }
        if (k < dist[x][y]) {
          dist[x][y] = k
          q.offer(intArrayOf(x, y))
        }
      }
    }
    return if (dist[di][dj] == inf) -1 else dist[di][dj]
  }
}
