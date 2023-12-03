class Solution {
  fun distinctSubseqII(s: String): Int {
    val dp = IntArray(26)
    var ans = 0
    for (i in 0 until s.length) {
      val j = s[i].code - 'a'.code
      val add: Int = (ans - dp[j] + 1) % Solution.Companion.MOD
      ans = (ans + add) % Solution.Companion.MOD
      dp[j] = (dp[j] + add) % Solution.Companion.MOD
    }
    return (ans + Solution.Companion.MOD) % Solution.Companion.MOD
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
