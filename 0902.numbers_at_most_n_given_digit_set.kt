internal class Solution {
  private val a = IntArray(12)
  private val dp = Array(12) { IntArray(2) }
  private val s: Set<Int> = HashSet()
  fun atMostNGivenDigitSet(digits: Array<String>, n: Int): Int {
    var n = n
    for (e in dp) {
      Arrays.fill(e, -1)
    }
    for (d in digits) {
      s.add(d.toInt())
    }
    var len = 0
    while (n > 0) {
      a[++len] = n % 10
      n /= 10
    }
    return dfs(len, 1, true)
  }

  private fun dfs(pos: Int, lead: Int, limit: Boolean): Int {
    if (pos <= 0) {
      return lead xor 1
    }
    if (!limit && lead != 1 && dp[pos][lead] != -1) {
      return dp[pos][lead]
    }
    var ans = 0
    val up = if (limit) a[pos] else 9
    for (i in 0..up) {
      if (i == 0 && lead == 1) {
        ans += dfs(pos - 1, lead, limit && i == up)
      } else if (s.contains(i)) {
        ans += dfs(pos - 1, 0, limit && i == up)
      }
    }
    if (!limit && lead == 0) {
      dp[pos][lead] = ans
    }
    return ans
  }
}
