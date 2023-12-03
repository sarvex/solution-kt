import kotlin.math.min

class Solution {
  fun numberOfSubstrings(s: String): Int {
    val d = intArrayOf(-1, -1, -1)
    var ans = 0
    for (i in 0 until s.length) {
      val c = s[i]
      d[c.code - 'a'.code] = i
      (ans += min(d[0].toDouble(), min(d[1].toDouble(), d[2].toDouble())) + 1).toInt()
    }
    return ans
  }
}
