internal class Solution {
  fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
    if (m * n != original.size) {
      return Array(0) { IntArray(0) }
    }
    val ans = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans[i][j] = original[i * n + j]
      }
    }
    return ans
  }
}
