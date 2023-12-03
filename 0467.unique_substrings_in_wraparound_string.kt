import kotlin.math.max

internal class Solution {
  fun findSubstringInWraproundString(p: String): Int {
    val dp = IntArray(26)
    var k = 0
    for (i in 0 until p.length) {
      val c = p[i]
      if (i > 0 && (c.code - p[i - 1].code + 26) % 26 == 1) {
        ++k
      } else {
        k = 1
      }
      dp[c.code - 'a'.code] = max(dp[c.code - 'a'.code].toDouble(), k.toDouble()).toInt()
    }
    var ans = 0
    for (v in dp) {
      ans += v
    }
    return ans
  }
}
