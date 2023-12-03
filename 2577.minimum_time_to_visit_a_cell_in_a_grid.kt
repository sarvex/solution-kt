class Solution {
  fun minimumTime(grid: Array<IntArray>): Int {
    if (grid[0][1] > 1 && grid[1][0] > 1) {
      return -1
    }
    val m = grid.size
    val n = grid[0].size
    val dist = Array(m) { IntArray(n) }
    for (e in dist) {
      Arrays.fill(e, 1 shl 30)
    }
    dist[0][0] = 0
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    pq.offer(intArrayOf(0, 0, 0))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (true) {
      val p: Unit = pq.poll()
      val i: Int = p.get(1)
      val j: Int = p.get(2)
      if (i == m - 1 && j == n - 1) {
        return p.get(0)
      }
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n) {
          var nt: Int = p.get(0) + 1
          if (nt < grid[x][y]) {
            nt = grid[x][y] + (grid[x][y] - nt) % 2
          }
          if (nt < dist[x][y]) {
            dist[x][y] = nt
            pq.offer(intArrayOf(nt, x, y))
          }
        }
      }
    }
  }
}
