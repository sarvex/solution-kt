class Solution {
  private var p: IntArray
  fun containsCycle(grid: Array<CharArray>): Boolean {
    val m = grid.size
    val n = grid[0].size
    p = IntArray(m * n)
    for (i in p.indices) {
      p[i] = i
    }
    val dirs = intArrayOf(0, 1, 0)
    for (i in 0 until m) {
      for (j in 0 until n) {
        for (k in 0..1) {
          val x = i + dirs[k]
          val y = j + dirs[k + 1]
          if (x < m && y < n && grid[i][j] == grid[x][y]) {
            if (find(x * n + y) == find(i * n + j)) {
              return true
            }
            p[find(x * n + y)] = find(i * n + j)
          }
        }
      }
    }
    return false
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
