internal class Solution {
  private val MOD = 1e9.toInt() + 7
  fun countPalindromicSubsequences(s: String): Int {
    val n = s.length
    val dp = Array(n) { Array(n) { LongArray(4) } }
    for (i in 0 until n) {
      dp[i][i][s[i].code - 'a'.code] = 1
    }
    for (l in 2..n) {
      var i = 0
      while (i + l <= n) {
        val j = i + l - 1
        var c = 'a'
        while (c <= 'd') {
          val k = c.code - 'a'.code
          if (s[i] == c && s[j] == c) {
            dp[i][j][k] = (2 + dp[i + 1][j - 1][0] + dp[i + 1][j - 1][1]
                + dp[i + 1][j - 1][2] + dp[i + 1][j - 1][3])
            dp[i][j][k] %= MOD.toLong()
          } else if (s[i] == c) {
            dp[i][j][k] = dp[i][j - 1][k]
          } else if (s[j] == c) {
            dp[i][j][k] = dp[i + 1][j][k]
          } else {
            dp[i][j][k] = dp[i + 1][j - 1][k]
          }
          ++c
        }
        ++i
      }
    }
    var ans: Long = 0
    for (k in 0..3) {
      ans += dp[0][n - 1][k]
    }
    return (ans % MOD).toInt()
  }
}
