import kotlin.math.max

internal class Solution {
  fun lastStoneWeightII(stones: IntArray): Int {
    var s = 0
    for (v in stones) {
      s += v
    }
    val m = stones.size
    val n = s shr 1
    val dp = IntArray(n + 1)
    for (v in stones) {
      for (j in n downTo v) {
        dp[j] = max(dp[j].toDouble(), (dp[j - v] + v).toDouble()).toInt()
      }
    }
    return s - dp[n] * 2
  }
}
