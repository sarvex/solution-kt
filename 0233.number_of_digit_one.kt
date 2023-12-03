internal class Solution {
  private val a = IntArray(12)
  private val dp = Array(12) { IntArray(12) }
  fun countDigitOne(n: Int): Int {
    var n = n
    var len = 0
    while (n > 0) {
      a[++len] = n % 10
      n /= 10
    }
    for (e in dp) {
      Arrays.fill(e, -1)
    }
    return dfs(len, 0, true)
  }

  private fun dfs(pos: Int, cnt: Int, limit: Boolean): Int {
    if (pos <= 0) {
      return cnt
    }
    if (!limit && dp[pos][cnt] != -1) {
      return dp[pos][cnt]
    }
    val up = if (limit) a[pos] else 9
    var ans = 0
    for (i in 0..up) {
      ans += dfs(pos - 1, cnt + if (i == 1) 1 else 0, limit && i == up)
    }
    if (!limit) {
      dp[pos][cnt] = ans
    }
    return ans
  }
}
