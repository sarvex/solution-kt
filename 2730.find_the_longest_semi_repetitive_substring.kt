import kotlin.math.max

class Solution {
  fun longestSemiRepetitiveSubstring(s: String): Int {
    val n = s.length
    var ans = 0
    var i = 0
    var j = 0
    var cnt = 0
    while (i < n) {
      if (i > 0 && s[i] == s[i - 1]) {
        ++cnt
      }
      while (cnt > 1) {
        if (s[j] == s[j + 1]) {
          --cnt
        }
        ++j
      }
      ans = max(ans.toDouble(), (i - j + 1).toDouble()).toInt()
      ++i
    }
    return ans
  }
}
