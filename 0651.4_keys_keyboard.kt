import kotlin.math.max

internal class Solution {
  fun maxA(n: Int): Int {
    val dp = IntArray(n + 1)
    for (i in 0 until n + 1) {
      dp[i] = i
    }
    for (i in 3 until n + 1) {
      for (j in 2 until i - 1) {
        dp[i] = max(dp[i].toDouble(), (dp[j - 1] * (i - j)).toDouble()).toInt()
      }
    }
    return dp[n]
  }
}
