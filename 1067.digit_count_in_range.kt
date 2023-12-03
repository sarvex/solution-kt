internal class Solution {
  private var d = 0
  private val a = IntArray(11)
  private val dp = Array(11) { IntArray(11) }
  fun digitsCount(d: Int, low: Int, high: Int): Int {
    this.d = d
    return f(high) - f(low - 1)
  }

  private fun f(n: Int): Int {
    var n = n
    for (e in dp) {
      Arrays.fill(e, -1)
    }
    var len = 0
    while (n > 0) {
      a[++len] = n % 10
      n /= 10
    }
    return dfs(len, 0, true, true)
  }

  private fun dfs(pos: Int, cnt: Int, lead: Boolean, limit: Boolean): Int {
    if (pos <= 0) {
      return cnt
    }
    if (!lead && !limit && dp[pos][cnt] != -1) {
      return dp[pos][cnt]
    }
    val up = if (limit) a[pos] else 9
    var ans = 0
    for (i in 0..up) {
      ans += if (i == 0 && lead) {
        dfs(pos - 1, cnt, lead, limit && i == up)
      } else {
        dfs(pos - 1, cnt + if (i == d) 1 else 0, false, limit && i == up)
      }
    }
    if (!lead && !limit) {
      dp[pos][cnt] = ans
    }
    return ans
  }
}
