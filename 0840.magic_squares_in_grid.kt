internal class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans += check(i, j)
      }
    }
    return ans
  }

  private fun check(i: Int, j: Int): Int {
    if (i + 3 > m || j + 3 > n) {
      return 0
    }
    val cnt = IntArray(16)
    val row = IntArray(3)
    val col = IntArray(3)
    var a = 0
    var b = 0
    for (x in i until i + 3) {
      for (y in j until j + 3) {
        val v = grid[x][y]
        if (v < 1 || v > 9 || ++cnt[v] > 1) {
          return 0
        }
        row[x - i] += v
        col[y - j] += v
        if (x - i == y - j) {
          a += v
        }
        if (x - i + y - j == 2) {
          b += v
        }
      }
    }
    if (a != b) {
      return 0
    }
    for (k in 0..2) {
      if (row[k] != a || col[k] != a) {
        return 0
      }
    }
    return 1
  }
}
