internal class Solution {
  fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
    val f = Array(k + 1) { Array(n) { DoubleArray(n) } }
    for (i in 0 until n) {
      for (j in 0 until n) {
        f[0][i][j] = 1.0
      }
    }
    val dirs = intArrayOf(-2, -1, 2, 1, -2, 1, 2, -1, -2)
    for (h in 1..k) {
      for (i in 0 until n) {
        for (j in 0 until n) {
          for (p in 0..7) {
            val x = i + dirs[p]
            val y = j + dirs[p + 1]
            if (x >= 0 && x < n && y >= 0 && y < n) {
              f[h][i][j] += f[h - 1][x][y] / 8
            }
          }
        }
      }
    }
    return f[k][row][column]
  }
}
