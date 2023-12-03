class Solution {
  fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
    val mod = 12345
    val n = grid.size
    val m = grid[0].size
    val p = Array(n) { IntArray(m) }
    var suf: Long = 1
    for (i in n - 1 downTo 0) {
      for (j in m - 1 downTo 0) {
        p[i][j] = suf.toInt()
        suf = suf * grid[i][j] % mod
      }
    }
    var pre: Long = 1
    for (i in 0 until n) {
      for (j in 0 until m) {
        p[i][j] = (p[i][j] * pre % mod).toInt()
        pre = pre * grid[i][j] % mod
      }
    }
    return p
  }
}
