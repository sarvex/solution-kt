import kotlin.math.min

internal class Solution {
  fun shortestToChar(s: String, c: Char): IntArray {
    val n = s.length
    val ans = IntArray(n)
    val inf = 1 shl 30
    Arrays.fill(ans, inf)
    run {
      var i = 0
      var pre = -inf
      while (i < n) {
        if (s[i] == c) {
          pre = i
        }
        ans[i] = min(ans[i].toDouble(), (i - pre).toDouble()).toInt()
        ++i
      }
    }
    var i = n - 1
    var suf = inf
    while (i >= 0) {
      if (s[i] == c) {
        suf = i
      }
      ans[i] = min(ans[i].toDouble(), (suf - i).toDouble()).toInt()
      --i
    }
    return ans
  }
}
