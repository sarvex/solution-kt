class Solution {
  private var p: IntArray
  private var row = 0
  private var col = 0
  private var grid: Array<BooleanArray>
  private val dirs = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0))
  fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
    val n = row * col
    this.row = row
    this.col = col
    p = IntArray(n + 2)
    for (i in p.indices) {
      p[i] = i
    }
    grid = Array(row) { BooleanArray(col) }
    val bottom = n + 1
    for (k in cells.indices.reversed()) {
      val i = cells[k][0] - 1
      val j = cells[k][1] - 1
      grid[i][j] = true
      for (e in dirs) {
        if (check(i + e[0], j + e[1])) {
          p[find(i * col + j)] = find((i + e[0]) * col + j + e[1])
        }
      }
      if (i == 0) {
        p[find(i * col + j)] = find(n)
      }
      if (i == row - 1) {
        p[find(i * col + j)] = find(bottom)
      }
      if (find(n) == find(bottom)) {
        return k
      }
    }
    return 0
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  private fun check(i: Int, j: Int): Boolean {
    return i >= 0 && i < row && j >= 0 && j < col && grid[i][j]
  }
}
