import kotlin.math.max

class Solution {
  fun maxScore(s: String): Int {
    var t = 0
    if (s[0] == '0') {
      t++
    }
    for (i in 1 until s.length) {
      if (s[i] == '1') {
        t++
      }
    }
    var ans = t
    for (i in 1 until s.length - 1) {
      t += if (s[i] == '0') 1 else -1
      ans = max(ans.toDouble(), t.toDouble()).toInt()
    }
    return ans
  }
}
