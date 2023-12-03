import kotlin.math.max

internal class Solution {
  private var p: IntArray
  private var size: IntArray
  fun hitBricks(grid: Array<IntArray>, hits: Array<IntArray>): IntArray {
    val m = grid.size
    val n = grid[0].size
    p = IntArray(m * n + 1)
    size = IntArray(m * n + 1)
    for (i in p.indices) {
      p[i] = i
      size[i] = 1
    }
    val g = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        g[i][j] = grid[i][j]
      }
    }
    for (h in hits) {
      g[h[0]][h[1]] = 0
    }
    for (j in 0 until n) {
      if (g[0][j] == 1) {
        union(j, m * n)
      }
    }
    for (i in 1 until m) {
      for (j in 0 until n) {
        if (g[i][j] == 0) {
          continue
        }
        if (g[i - 1][j] == 1) {
          union(i * n + j, (i - 1) * n + j)
        }
        if (j > 0 && g[i][j - 1] == 1) {
          union(i * n + j, i * n + j - 1)
        }
      }
    }
    val ans = IntArray(hits.size)
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in hits.indices.reversed()) {
      val i = hits[k][0]
      val j = hits[k][1]
      if (grid[i][j] == 0) {
        continue
      }
      g[i][j] = 1
      val prev = size[find(m * n)]
      if (i == 0) {
        union(j, m * n)
      }
      for (l in 0..3) {
        val x = i + dirs[l]
        val y = j + dirs[l + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == 1) {
          union(i * n + j, x * n + y)
        }
      }
      val curr = size[find(m * n)]
      ans[k] = max(0.0, (curr - prev - 1).toDouble()).toInt()
    }
    return ans
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
    if (pa != pb) {
      size[pb] += size[pa]
      p[pa] = pb
    }
  }
}
