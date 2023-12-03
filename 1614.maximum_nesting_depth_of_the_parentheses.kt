import kotlin.math.max

class Solution {
  fun maxDepth(s: String): Int {
    var ans = 0
    var d = 0
    for (i in 0 until s.length) {
      val c = s[i]
      if (c == '(') {
        ans = max(ans.toDouble(), ++d.toDouble()).toInt()
      } else if (c == ')') {
        --d
      }
    }
    return ans
  }
}
