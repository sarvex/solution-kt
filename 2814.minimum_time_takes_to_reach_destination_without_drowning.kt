class Solution {
  fun minimumSeconds(land: List<List<String>>): Int {
    val m: Int = land.size()
    val n: Int = land[0].size()
    var vis = Array(m) { BooleanArray(n) }
    val g = Array(m) { IntArray(n) }
    val q: Deque<IntArray> = ArrayDeque()
    var si = 0
    var sj = 0
    for (i in 0 until m) {
      Arrays.fill(g[i], 1 shl 30)
      for (j in 0 until n) {
        val c = land[i][j]
        if ("*" == c) {
          q.offer(intArrayOf(i, j))
        } else if ("S" == c) {
          si = i
          sj = j
        }
      }
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    run {
      var t = 0
      while (!q.isEmpty()) {
        for (k in q.size() downTo 1) {
          val p: IntArray = q.poll()
          val i = p[0]
          val j = p[1]
          g[i][j] = t
          for (d in 0..3) {
            val x = i + dirs[d]
            val y = j + dirs[d + 1]
            if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
              val empty = "." == land[x][y]
              val start = "S" == land[x][y]
              if (empty || start) {
                vis[x][y] = true
                q.offer(intArrayOf(x, y))
              }
            }
          }
        }
        ++t
      }
    }
    q.offer(intArrayOf(si, sj))
    vis = Array(m) { BooleanArray(n) }
    vis[si][sj] = true
    var t = 0
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val p: IntArray = q.poll()
        val i = p[0]
        val j = p[1]
        if ("D" == land[i][j]) {
          return t
        }
        for (d in 0..3) {
          val x = i + dirs[d]
          val y = j + dirs[d + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && g[x][y] > t + 1) {
            val empty = "." == land[x][y]
            val dest = "D" == land[x][y]
            if (empty || dest) {
              vis[x][y] = true
              q.offer(intArrayOf(x, y))
            }
          }
        }
      }
      ++t
    }
    return -1
  }
}
