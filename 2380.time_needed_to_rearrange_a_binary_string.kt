import kotlin.math.max

class Solution {
  fun secondsToRemoveOccurrences(s: String): Int {
    var ans = 0
    var cnt = 0
    for (c in s.toCharArray()) {
      if (c == '0') {
        ++cnt
      } else if (cnt > 0) {
        ans = max((ans + 1).toDouble(), cnt.toDouble()).toInt()
      }
    }
    return ans
  }
}
