internal class Solution {
  fun checkRecord(n: Int): Int {
    val dp = Array(n) { Array(2) { LongArray(3) } }

    // base case
    dp[0][0][0] = 1
    dp[0][0][1] = 1
    dp[0][1][0] = 1
    for (i in 1 until n) {
      // A
      dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % Solution.Companion.MOD
      // L
      dp[i][0][1] = dp[i - 1][0][0]
      dp[i][0][2] = dp[i - 1][0][1]
      dp[i][1][1] = dp[i - 1][1][0]
      dp[i][1][2] = dp[i - 1][1][1]
      // P
      dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % Solution.Companion.MOD
      dp[i][1][0] = (dp[i][1][0] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % Solution.Companion.MOD
    }
    var ans: Long = 0
    for (j in 0..1) {
      for (k in 0..2) {
        ans = (ans + dp[n - 1][j][k]) % Solution.Companion.MOD
      }
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1000000007
  }
}
