import kotlin.math.max

class Solution {
  fun minDeletionSize(strs: Array<String>): Int {
    val n = strs[0].length
    val dp = IntArray(n)
    Arrays.fill(dp, 1)
    var mx = 1
    for (i in 1 until n) {
      for (j in 0 until i) {
        if (check(i, j, strs)) {
          dp[i] = max(dp[i].toDouble(), (dp[j] + 1).toDouble()).toInt()
        }
      }
      mx = max(mx.toDouble(), dp[i].toDouble()).toInt()
    }
    return n - mx
  }

  private fun check(i: Int, j: Int, strs: Array<String>): Boolean {
    for (s in strs) {
      if (s[i] < s[j]) {
        return false
      }
    }
    return true
  }
}
