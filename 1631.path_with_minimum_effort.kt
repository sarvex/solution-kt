import kotlin.math.abs
import kotlin.math.max

class Solution {
  fun minimumEffortPath(heights: Array<IntArray>): Int {
    val m = heights.size
    val n = heights[0].size
    val dist = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      Arrays.fill(dist[i], 0x3f3f3f3f)
    }
    dist[0][0] = 0
    val q: PriorityQueue<IntArray> = PriorityQueue(Comparator.comparingInt { a -> a.get(0) })
    q.offer(intArrayOf(0, 0, 0))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val p: IntArray = q.poll()
      val t = p[0]
      val i = p[1]
      val j = p[2]
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n) {
          val nd = max(t.toDouble(), abs((heights[x][y] - heights[i][j]).toDouble()))
            .toInt()
          if (nd < dist[x][y]) {
            dist[x][y] = nd
            q.offer(intArrayOf(nd, x, y))
          }
        }
      }
    }
    return dist[m - 1][n - 1]
  }
}
