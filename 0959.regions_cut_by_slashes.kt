class Solution {
  private var p: IntArray
  private var size = 0
  fun regionsBySlashes(grid: Array<String>): Int {
    val n = grid.size
    size = n * n * 4
    p = IntArray(size)
    for (i in p.indices) {
      p[i] = i
    }
    for (i in 0 until n) {
      for (j in 0 until n) {
        val k = i * n + j
        if (i < n - 1) {
          union(4 * k + 2, (k + n) * 4)
        }
        if (j < n - 1) {
          union(4 * k + 1, (k + 1) * 4 + 3)
        }
        val v = grid[i][j]
        if (v == '/') {
          union(4 * k, 4 * k + 3)
          union(4 * k + 1, 4 * k + 2)
        } else if (v == '\\') {
          union(4 * k, 4 * k + 1)
          union(4 * k + 2, 4 * k + 3)
        } else {
          union(4 * k, 4 * k + 1)
          union(4 * k + 1, 4 * k + 2)
          union(4 * k + 2, 4 * k + 3)
        }
      }
    }
    return size
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  private fun union(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return
    }
    p[pa] = pb
    --size
  }
}
