internal class Solution {
  private var p: IntArray
  fun maximumMinimumPath(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    p = IntArray(m * n)
    val q: List<IntArray> = ArrayList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        q.add(intArrayOf(grid[i][j], i, j))
        p[i * n + j] = i * n + j
      }
    }
    q.sort { a, b -> b.get(0) - a.get(0) }
    val vis = Array(m) { BooleanArray(n) }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    var ans = 0
    var i = 0
    while (find(0) != find(m * n - 1)) {
      val t = q[i]
      vis[t[1]][t[2]] = true
      ans = t[0]
      for (k in 0..3) {
        val x = t[1] + dirs[k]
        val y = t[2] + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && vis[x][y]) {
          p[find(x * n + y)] = find(t[1] * n + t[2])
        }
      }
      ++i
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
