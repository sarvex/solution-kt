import kotlin.math.min

internal class Solution {
  fun balancedString(s: String): Int {
    val cnt = IntArray(4)
    val t = "QWER"
    val n = s.length
    for (i in 0 until n) {
      cnt[t.indexOf(s[i])]++
    }
    val m = n / 4
    if (cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m) {
      return 0
    }
    var ans = n
    var i = 0
    var j = 0
    while (i < n) {
      cnt[t.indexOf(s[i])]--
      while (j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m) {
        ans = min(ans.toDouble(), (i - j + 1).toDouble()).toInt()
        cnt[t.indexOf(s[j++])]++
      }
      ++i
    }
    return ans
  }
}
