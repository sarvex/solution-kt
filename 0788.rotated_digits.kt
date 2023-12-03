internal class Solution {
  private val a = IntArray(6)
  private val dp = Array(6) { IntArray(2) }
  fun rotatedDigits(n: Int): Int {
    var n = n
    var len = 0
    for (e in dp) {
      Arrays.fill(e, -1)
    }
    while (n > 0) {
      a[++len] = n % 10
      n /= 10
    }
    return dfs(len, 0, true)
  }

  private fun dfs(pos: Int, ok: Int, limit: Boolean): Int {
    if (pos <= 0) {
      return ok
    }
    if (!limit && dp[pos][ok] != -1) {
      return dp[pos][ok]
    }
    val up = if (limit) a[pos] else 9
    var ans = 0
    for (i in 0..up) {
      if (i == 0 || i == 1 || i == 8) {
        ans += dfs(pos - 1, ok, limit && i == up)
      }
      if (i == 2 || i == 5 || i == 6 || i == 9) {
        ans += dfs(pos - 1, 1, limit && i == up)
      }
    }
    if (!limit) {
      dp[pos][ok] = ans
    }
    return ans
  }
}
