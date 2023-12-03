class Solution {
  fun numSpecial(mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    val r = IntArray(m)
    val c = IntArray(n)
    for (i in 0 until m) {
      for (j in 0 until n) {
        r[i] += mat[i][j]
        c[j] += mat[i][j]
      }
    }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) {
          ++ans
        }
      }
    }
    return ans
  }
}
