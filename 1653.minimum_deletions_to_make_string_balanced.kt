import kotlin.math.min

class Solution {
  fun minimumDeletions(s: String): Int {
    val n = s.length
    var ans = 0
    var b = 0
    for (i in 0 until n) {
      if (s[i] == 'b') {
        ++b
      } else {
        ans = min((ans + 1).toDouble(), b.toDouble()).toInt()
      }
    }
    return ans
  }
}
