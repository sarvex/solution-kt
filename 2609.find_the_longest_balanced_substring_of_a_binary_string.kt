import kotlin.math.max
import kotlin.math.min

class Solution {
  fun findTheLongestBalancedSubstring(s: String): Int {
    var zero = 0
    var one = 0
    var ans = 0
    val n = s.length
    for (i in 0 until n) {
      if (s[i] == '0') {
        if (one > 0) {
          zero = 0
          one = 0
        }
        ++zero
      } else {
        ans = max(ans.toDouble(), (2 * min(zero.toDouble(), ++one.toDouble())).toDouble())
          .toInt()
      }
    }
    return ans
  }
}
