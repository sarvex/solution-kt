class Solution {
  fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
    val m = grid.size
    val n = grid[0].size
    val rows = IntArray(m)
    val cols = IntArray(n)
    for (i in 0 until m) {
      for (j in 0 until n) {
        val v = grid[i][j]
        rows[i] += v
        cols[j] += v
      }
    }
    val diff = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        diff[i][j] = rows[i] + cols[j] - (n - rows[i]) - (m - cols[j])
      }
    }
    return diff
  }
}
