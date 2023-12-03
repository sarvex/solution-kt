import kotlin.math.min

class Solution {
  fun minimumCost(s: String): Long {
    var ans: Long = 0
    val n = s.length
    for (i in 1 until n) {
      if (s[i] != s[i - 1]) {
        (ans += min(i.toDouble(), (n - i).toDouble())).toLong()
      }
    }
    return ans
  }
}
