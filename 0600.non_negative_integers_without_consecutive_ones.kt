internal class Solution {
  private val a = IntArray(33)
  private val dp = Array(33) { IntArray(2) }
  fun findIntegers(n: Int): Int {
    var n = n
    var len = 0
    while (n > 0) {
      a[++len] = n and 1
      n = n shr 1
    }
    for (e in dp) {
      Arrays.fill(e, -1)
    }
    return dfs(len, 0, true)
  }

  private fun dfs(pos: Int, pre: Int, limit: Boolean): Int {
    if (pos <= 0) {
      return 1
    }
    if (!limit && dp[pos][pre] != -1) {
      return dp[pos][pre]
    }
    val up = if (limit) a[pos] else 1
    var ans = 0
    for (i in 0..up) {
      if (!(pre == 1 && i == 1)) {
        ans += dfs(pos - 1, i, limit && i == up)
      }
    }
    if (!limit) {
      dp[pos][pre] = ans
    }
    return ans
  }
}
