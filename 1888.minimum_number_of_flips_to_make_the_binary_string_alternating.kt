import kotlin.math.min

class Solution {
  fun minFlips(s: String): Int {
    val n = s.length
    val target = "01"
    var cnt = 0
    for (i in 0 until n) {
      if (s[i] != target[i and 1]) {
        ++cnt
      }
    }
    var ans = min(cnt.toDouble(), (n - cnt).toDouble()).toInt()
    for (i in 0 until n) {
      if (s[i] != target[i and 1]) {
        --cnt
      }
      if (s[i] != target[i + n and 1]) {
        ++cnt
      }
      ans = min(ans.toDouble(), min(cnt.toDouble(), (n - cnt).toDouble())).toInt()
    }
    return ans
  }
}
