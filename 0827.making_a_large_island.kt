import kotlin.math.max

internal class Solution {
  private var n = 0
  private var p: IntArray
  private var size: IntArray
  private var ans = 1
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  fun largestIsland(grid: Array<IntArray>): Int {
    n = grid.size
    p = IntArray(n * n)
    size = IntArray(n * n)
    for (i in p.indices) {
      p[i] = i
      size[i] = 1
    }
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          for (k in 0..3) {
            val x = i + dirs[k]
            val y = j + dirs[k + 1]
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
              val pa = find(x * n + y)
              val pb = find(i * n + j)
              if (pa == pb) {
                continue
              }
              p[pa] = pb
              size[pb] += size[pa]
              ans = max(ans.toDouble(), size[pb].toDouble()).toInt()
            }
          }
        }
      }
    }
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] == 0) {
          var t = 1
          val vis: Set<Int> = HashSet()
          for (k in 0..3) {
            val x = i + dirs[k]
            val y = j + dirs[k + 1]
            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
              val root = find(x * n + y)
              if (!vis.contains(root)) {
                vis.add(root)
                t += size[root]
              }
            }
          }
          ans = max(ans.toDouble(), t.toDouble()).toInt()
        }
      }
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
