import kotlin.math.max
import kotlin.math.min

class Solution {
  fun beautySum(s: String): Int {
    var ans = 0
    val n = s.length
    for (i in 0 until n) {
      val cnt = IntArray(26)
      for (j in i until n) {
        ++cnt[s[j].code - 'a'.code]
        var mi = 1000
        var mx = 0
        for (v in cnt) {
          if (v > 0) {
            mi = min(mi.toDouble(), v.toDouble()).toInt()
            mx = max(mx.toDouble(), v.toDouble()).toInt()
          }
        }
        ans += mx - mi
      }
    }
    return ans
  }
}
