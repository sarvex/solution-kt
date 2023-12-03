class Solution {
  fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
    var k = queries.size
    val qs = Array(k) { IntArray(2) }
    for (i in 0 until k) {
      qs[i] = intArrayOf(queries[i], i)
    }
    Arrays.sort(qs) { a, b -> a.get(0) - b.get(0) }
    val ans = IntArray(k)
    val m = grid.size
    val n = grid[0].size
    val vis = Array(m) { BooleanArray(n) }
    vis[0][0] = true
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    q.offer(intArrayOf(grid[0][0], 0, 0))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    var cnt = 0
    for (e in qs) {
      val v = e[0]
      k = e[1]
      while (!q.isEmpty() && q.peek().get(0) < v) {
        val p: Unit = q.poll()
        ++cnt
        for (h in 0..3) {
          val x: Int = p.get(1) + dirs[h]
          val y: Int = p.get(2) + dirs[h + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
            vis[x][y] = true
            q.offer(intArrayOf(grid[x][y], x, y))
          }
        }
      }
      ans[k] = cnt
    }
    return ans
  }
}
