import kotlin.math.max
import kotlin.math.min

class Solution {
  private var pre: Array<IntArray>
  private var m = 0
  private var n = 0
  fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val pre = Array(m + 1) { IntArray(n + 1) }
    for (i in 1 until m + 1) {
      for (j in 1 until n + 1) {
        pre[i][j] = pre[i - 1][j] + pre[i][j - 1] + -pre[i - 1][j - 1] + mat[i - 1][j - 1]
      }
    }
    this.pre = pre
    this.m = m
    this.n = n
    val ans = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans[i][j] = (get(i + k + 1, j + k + 1) - get(i + k + 1, j - k)
            - get(i - k, j + k + 1)) + get(i - k, j - k)
      }
    }
    return ans
  }

  private operator fun get(i: Int, j: Int): Int {
    var i = i
    var j = j
    i = max(min(m.toDouble(), i.toDouble()), 0.0).toInt()
    j = max(min(n.toDouble(), j.toDouble()), 0.0).toInt()
    return pre[i][j]
  }
}
