import kotlin.math.max

class Solution {
  fun getMaxFunctionValue(receiver: List<Int>, k: Long): Long {
    val n: Int = receiver.size()
    val m = 64 - java.lang.Long.numberOfLeadingZeros(k)
    val f = Array(n) { IntArray(m) }
    val g = Array(n) { LongArray(m) }
    for (i in 0 until n) {
      f[i][0] = receiver[i]
      g[i][0] = i.toLong()
    }
    for (j in 1 until m) {
      for (i in 0 until n) {
        f[i][j] = f[f[i][j - 1]][j - 1]
        g[i][j] = g[i][j - 1] + g[f[i][j - 1]][j - 1]
      }
    }
    var ans: Long = 0
    for (i in 0 until n) {
      var p = i
      var t: Long = 0
      for (j in 0 until m) {
        if (k shr j and 1L == 1L) {
          t += g[p][j]
          p = f[p][j]
        }
      }
      ans = max(ans.toDouble(), (p + t).toDouble()).toLong()
    }
    return ans
  }
}
