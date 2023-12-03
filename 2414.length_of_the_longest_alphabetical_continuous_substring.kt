import kotlin.math.max

class Solution {
  fun longestContinuousSubstring(s: String): Int {
    var ans = 0
    var i = 0
    var j = 1
    while (j < s.length) {
      ans = max(ans.toDouble(), (j - i).toDouble()).toInt()
      if (s[j].code - s[j - 1].code != 1) {
        i = j
      }
      ++j
    }
    ans = max(ans.toDouble(), (j - i).toDouble()).toInt()
    return ans
  }
}
