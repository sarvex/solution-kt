internal class Solution {
  fun findNumberOfLIS(nums: IntArray): Int {
    var maxLen = 0
    var ans = 0
    val n = nums.size
    val dp = IntArray(n)
    val cnt = IntArray(n)
    for (i in 0 until n) {
      dp[i] = 1
      cnt[i] = 1
      for (j in 0 until i) {
        if (nums[i] > nums[j]) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1
            cnt[i] = cnt[j]
          } else if (dp[j] + 1 == dp[i]) {
            cnt[i] += cnt[j]
          }
        }
      }
      if (dp[i] > maxLen) {
        maxLen = dp[i]
        ans = cnt[i]
      } else if (dp[i] == maxLen) {
        ans += cnt[i]
      }
    }
    return ans
  }
}
