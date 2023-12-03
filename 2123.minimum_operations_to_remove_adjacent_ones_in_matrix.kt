internal class Solution {
  private val g: Map<Int, List<Int>> = HashMap()
  private val vis: Set<Int> = HashSet()
  private var match: IntArray
  fun minimumOperations(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        if ((i + j) % 2 == 1 && grid[i][j] == 1) {
          val x = i * n + j
          if (i < m - 1 && grid[i + 1][j] == 1) {
            g.computeIfAbsent(x) { z -> ArrayList() }.add(x + n)
          }
          if (i > 0 && grid[i - 1][j] == 1) {
            g.computeIfAbsent(x) { z -> ArrayList() }.add(x - n)
          }
          if (j < n - 1 && grid[i][j + 1] == 1) {
            g.computeIfAbsent(x) { z -> ArrayList() }.add(x + 1)
          }
          if (j > 0 && grid[i][j - 1] == 1) {
            g.computeIfAbsent(x) { z -> ArrayList() }.add(x - 1)
          }
        }
      }
    }
    match = IntArray(m * n)
    Arrays.fill(match, -1)
    var ans = 0
    for (i in g.keySet()) {
      ans += find(i)
      vis.clear()
    }
    return ans
  }

  private fun find(i: Int): Int {
    for (j in g[i]!!) {
      if (vis.add(j)) {
        if (match[j] == -1 || find(match[j]) == 1) {
          match[j] = i
          return 1
        }
      }
    }
    return 0
  }
}
