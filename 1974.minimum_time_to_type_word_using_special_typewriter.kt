import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun minTimeToType(word: String): Int {
    var ans = 0
    var prev = 0
    for (c in word.toCharArray()) {
      val curr = c.code - 'a'.code
      var t = abs((prev - curr).toDouble()).toInt()
      t = min(t.toDouble(), (26 - t).toDouble()).toInt()
      ans += t + 1
      prev = curr
    }
    return ans
  }
}
