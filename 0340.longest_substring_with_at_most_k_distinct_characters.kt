import kotlin.math.max

internal class Solution {
  fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
    val cnt: Map<Char, Int> = HashMap()
    val n = s.length
    var ans = 0
    var j = 0
    for (i in 0 until n) {
      val c = s[i]
      cnt.put(c, (cnt[c] ?: 0) + 1)
      while (cnt.size() > k) {
        val t = s[j]
        cnt.put(t, (cnt[t] ?: 0) - 1)
        if (cnt[t] === 0) {
          cnt.remove(t)
        }
        ++j
      }
      ans = max(ans.toDouble(), (i - j + 1).toDouble()).toInt()
    }
    return ans
  }
}
