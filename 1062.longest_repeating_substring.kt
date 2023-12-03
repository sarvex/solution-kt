import kotlin.math.max

internal class Solution {
  fun longestRepeatingSubstring(s: String): Int {
    val n = s.length
    var ans = 0
    val dp = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          dp[i][j] = if (i > 0) dp[i - 1][j - 1] + 1 else 1
          ans = max(ans.toDouble(), dp[i][j].toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
