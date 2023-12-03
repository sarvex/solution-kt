internal class Solution {
  fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
    val f = Array(101) { DoubleArray(101) }
    f[0][0] = poured.toDouble()
    for (i in 0..query_row) {
      for (j in 0..i) {
        if (f[i][j] > 1) {
          val half = (f[i][j] - 1) / 2.0
          f[i][j] = 1.0
          f[i + 1][j] += half
          f[i + 1][j + 1] += half
        }
      }
    }
    return f[query_row][query_glass]
  }
}
