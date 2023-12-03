class Solution {
  fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
    val g = Array(m) { IntArray(n) }
    for (e in guards) {
      g[e[0]][e[1]] = 2
    }
    for (e in walls) {
      g[e[0]][e[1]] = 2
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (e in guards) {
      for (k in 0..3) {
        var x = e[0]
        var y = e[1]
        val a = dirs[k]
        val b = dirs[k + 1]
        while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && g[x + a][y + b] < 2) {
          x += a
          y += b
          g[x][y] = 1
        }
      }
    }
    var ans = 0
    for (row in g) {
      for (v in row) {
        if (v == 0) {
          ++ans
        }
      }
    }
    return ans
  }
}
