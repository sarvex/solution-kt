import kotlin.math.abs
import kotlin.math.max

internal class Solution {
  fun equalSubstring(s: String, t: String, maxCost: Int): Int {
    val n = s.length
    var sum = 0
    var ans = 0
    var i = 0
    var j = 0
    while (i < n) {
      (sum += abs((s[i].code - t[i].code).toDouble())).toInt()
      while (sum > maxCost) {
        (sum -= abs((s[j].code - t[j].code).toDouble())).toInt()
        ++j
      }
      ans = max(ans.toDouble(), (i - j + 1).toDouble()).toInt()
      ++i
    }
    return ans
  }
}
