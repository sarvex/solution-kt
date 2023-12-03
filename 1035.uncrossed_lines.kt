import kotlin.math.max

internal class Solution {
  fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
    val m = nums1.size
    val n = nums2.size
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1
        } else {
          dp[i][j] = max(dp[i - 1][j].toDouble(), dp[i][j - 1].toDouble())
            .toInt()
        }
      }
    }
    return dp[m][n]
  }
}
