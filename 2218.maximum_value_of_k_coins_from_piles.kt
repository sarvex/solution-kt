import kotlin.math.max

class Solution {
  fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
    val n: Int = piles.size()
    val presum: List<IntArray> = ArrayList()
    for (p in piles) {
      val m: Int = p.size()
      val s = IntArray(m + 1)
      for (i in 0 until m) {
        s[i + 1] = s[i] + p[i]
      }
      presum.add(s)
    }
    val dp = IntArray(k + 1)
    for (s in presum) {
      for (j in k downTo 0) {
        for (idx in s.indices) {
          if (j >= idx) {
            dp[j] = max(dp[j].toDouble(), (dp[j - idx] + s[idx]).toDouble()).toInt()
          }
        }
      }
    }
    return dp[k]
  }
}
