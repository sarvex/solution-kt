import kotlin.math.max

internal class Solution {
  fun maxCoins(nums: IntArray): Int {
    val vals = IntArray(nums.size + 2)
    vals[0] = 1
    vals[vals.size - 1] = 1
    System.arraycopy(nums, 0, vals, 1, nums.size)
    val n = vals.size
    val dp = Array(n) { IntArray(n) }
    for (l in 2 until n) {
      var i = 0
      while (i + l < n) {
        val j = i + l
        for (k in i + 1 until j) {
          dp[i][j] = max(
            dp[i][j].toDouble(),
            (dp[i][k] + dp[k][j] + vals[i] * vals[k] * vals[j]).toDouble()
          ).toInt()
        }
        ++i
      }
    }
    return dp[0][n - 1]
  }
}
