import kotlin.math.max

class Solution {
  private var dp: Array<BooleanArray>
  private var f: IntArray
  private var s: String? = null
  private var n = 0
  private var k = 0
  fun maxPalindromes(s: String, k: Int): Int {
    n = s.length
    f = IntArray(n)
    this.s = s
    this.k = k
    dp = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
      Arrays.fill(dp[i], true)
      f[i] = -1
    }
    for (i in n - 1 downTo 0) {
      for (j in i + 1 until n) {
        dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
      }
    }
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != -1) {
      return f[i]
    }
    var ans = dfs(i + 1)
    for (j in i + k - 1 until n) {
      if (dp[i][j]) {
        ans = max(ans.toDouble(), (1 + dfs(j + 1)).toDouble()).toInt()
      }
    }
    f[i] = ans
    return ans
  }
}
