import kotlin.math.min

internal class Solution {
  fun nthUglyNumber(n: Int): Int {
    val dp = IntArray(n)
    dp[0] = 1
    var p2 = 0
    var p3 = 0
    var p5 = 0
    for (i in 1 until n) {
      val next2 = dp[p2] * 2
      val next3 = dp[p3] * 3
      val next5 = dp[p5] * 5
      dp[i] = min(next2.toDouble(), min(next3.toDouble(), next5.toDouble())).toInt()
      if (dp[i] == next2) ++p2
      if (dp[i] == next3) ++p3
      if (dp[i] == next5) ++p5
    }
    return dp[n - 1]
  }
}
