import kotlin.math.min

class Solution {
  fun minimumTime(s: String): Int {
    val n = s.length
    val pre = IntArray(n + 1)
    val suf = IntArray(n + 1)
    for (i in 0 until n) {
      pre[i + 1] = if (s[i] == '0') pre[i] else min((pre[i] + 2).toDouble(), (i + 1).toDouble())
        .toInt()
    }
    for (i in n - 1 downTo 0) {
      suf[i] = if (s[i] == '0') suf[i + 1] else min((suf[i + 1] + 2).toDouble(), (n - i).toDouble())
        .toInt()
    }
    var ans = Int.MAX_VALUE
    for (i in 1..n) {
      ans = min(ans.toDouble(), (pre[i] + suf[i]).toDouble()).toInt()
    }
    return ans
  }
}
