internal class Solution {
  private var p: IntArray
  fun swimInWater(grid: Array<IntArray>): Int {
    val n = grid.size
    p = IntArray(n * n)
    for (i in p.indices) {
      p[i] = i
    }
    val hi = IntArray(n * n)
    for (i in 0 until n) {
      for (j in 0 until n) {
        hi[grid[i][j]] = i * n + j
      }
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (t in 0 until n * n) {
      val i = hi[t] / n
      val j = hi[t] % n
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] <= t) {
          p[find(x * n + y)] = find(i * n + j)
        }
        if (find(0) == find(n * n - 1)) {
          return t
        }
      }
    }
    return -1
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
