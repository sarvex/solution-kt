internal class Solution {
  fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    if (m * n != r * c) {
      return mat
    }
    val ans = Array(r) { IntArray(c) }
    for (i in 0 until m * n) {
      ans[i / c][i % c] = mat[i / n][i % n]
    }
    return ans
  }
}
