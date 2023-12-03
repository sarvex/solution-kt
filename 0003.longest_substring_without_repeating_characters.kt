import kotlin.math.max

internal class Solution {
  fun lengthOfLongestSubstring(s: String): Int {
    val ss: Set<Char> = HashSet()
    var i = 0
    var ans = 0
    for (j in 0 until s.length) {
      val c = s[j]
      while (ss.contains(c)) {
        ss.remove(s[i++])
      }
      ss.add(c)
      ans = max(ans.toDouble(), (j - i + 1).toDouble()).toInt()
    }
    return ans
  }
}
