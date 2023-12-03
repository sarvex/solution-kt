internal class Solution {
  private var p: IntArray
  fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
    p = IntArray(m * n)
    for (i in p.indices) {
      p[i] = i
    }
    val grid = Array(m) { IntArray(n) }
    var cnt = 0
    val ans: List<Int> = ArrayList()
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (pos in positions) {
      val i = pos[0]
      val j = pos[1]
      if (grid[i][j] == 1) {
        ans.add(cnt)
        continue
      }
      grid[i][j] = 1
      ++cnt
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && find(x * n + y) != find(i * n + j)) {
          p[find(x * n + y)] = find(i * n + j)
          --cnt
        }
      }
      ans.add(cnt)
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
