import kotlin.math.abs
import kotlin.math.max

class Solution {
  fun longestIdealString(s: String, k: Int): Int {
    val n = s.length
    var ans = 1
    val dp = IntArray(n)
    Arrays.fill(dp, 1)
    val d: Map<Char, Int> = HashMap(26)
    d.put(s[0], 0)
    for (i in 1 until n) {
      val a = s[i]
      var b = 'a'
      while (b <= 'z') {
        if (abs((a.code - b.code).toDouble()) > k) {
          ++b
          continue
        }
        if (d.containsKey(b)) {
          dp[i] = max(dp[i].toDouble(), (dp[d[b]!!] + 1).toDouble()).toInt()
        }
        ++b
      }
      d.put(a, i)
      ans = max(ans.toDouble(), dp[i].toDouble()).toInt()
    }
    return ans
  }
}
