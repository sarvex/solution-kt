internal class Solution {
  private val nums = IntArray(11)
  private val dp = Array<Array<Int>>(11) { arrayOfNulls(1 shl 11) }
  fun numDupDigitsAtMostN(n: Int): Int {
    return n - f(n)
  }

  private fun f(n: Int): Int {
    var n = n
    var i = -1
    while (n > 0) {
      nums[++i] = n % 10
      n /= 10
    }
    return dfs(i, 0, true, true)
  }

  private fun dfs(pos: Int, mask: Int, lead: Boolean, limit: Boolean): Int {
    if (pos < 0) {
      return if (lead) 0 else 1
    }
    if (!lead && !limit && dp[pos][mask] != null) {
      return dp[pos][mask]
    }
    var ans = 0
    val up = if (limit) nums[pos] else 9
    for (i in 0..up) {
      if (mask shr i and 1 == 1) {
        continue
      }
      ans += if (i == 0 && lead) {
        dfs(pos - 1, mask, lead, limit && i == up)
      } else {
        dfs(pos - 1, mask or (1 shl i), false, limit && i == up)
      }
    }
    if (!lead && !limit) {
      dp[pos][mask] = ans
    }
    return ans
  }
}
