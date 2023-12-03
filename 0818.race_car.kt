import kotlin.math.min

internal class Solution {
  fun racecar(target: Int): Int {
    val dp = IntArray(target + 1)
    for (i in 1..target) {
      val k = 32 - Integer.numberOfLeadingZeros(i)
      if (i == (1 shl k) - 1) {
        dp[i] = k
        continue
      }
      dp[i] = dp[(1 shl k) - 1 - i] + k + 1
      for (j in 0 until k) {
        dp[i] = min(dp[i].toDouble(), (dp[i - (1 shl k - 1) + (1 shl j)] + k - 1 + j + 2).toDouble())
          .toInt()
      }
    }
    return dp[target]
  }
}
