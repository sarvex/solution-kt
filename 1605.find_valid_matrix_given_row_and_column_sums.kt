import kotlin.math.min

class Solution {
  fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
    val m = rowSum.size
    val n = colSum.size
    val ans = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        val x = min(rowSum[i].toDouble(), colSum[j].toDouble()).toInt()
        ans[i][j] = x
        rowSum[i] -= x
        colSum[j] -= x
      }
    }
    return ans
  }
}
