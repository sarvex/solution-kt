import kotlin.math.max

class Solution {
  fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
    val m = nums1.size
    val n = nums2.size
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (e in dp) {
      Arrays.fill(e, Int.MIN_VALUE)
    }
    for (i in 1..m) {
      for (j in 1..n) {
        dp[i][j] = max(dp[i - 1][j].toDouble(), dp[i][j - 1].toDouble()).toInt()
        dp[i][j] = max(
          dp[i][j].toDouble(), (max(0.0, dp[i - 1][j - 1].toDouble()) + nums1[i - 1] * nums2[j - 1]).toDouble()
        )
          .toInt()
      }
    }
    return dp[m][n]
  }
}
