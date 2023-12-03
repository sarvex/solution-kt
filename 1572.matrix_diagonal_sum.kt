class Solution {
  fun diagonalSum(mat: Array<IntArray>): Int {
    var ans = 0
    val n = mat.size
    for (i in 0 until n) {
      val j = n - i - 1
      ans += mat[i][i] + if (i == j) 0 else mat[i][j]
    }
    return ans
  }
}
