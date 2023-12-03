internal class Solution {
  fun findTargetSumWays(nums: IntArray, target: Int): Int {
    var s = 0
    for (v in nums) {
      s += v
    }
    if (s < target || (s - target) % 2 != 0) {
      return 0
    }
    val n = (s - target) / 2
    val dp = IntArray(n + 1)
    dp[0] = 1
    for (v in nums) {
      for (j in n downTo v) {
        dp[j] += dp[j - v]
      }
    }
    return dp[n]
  }
}
