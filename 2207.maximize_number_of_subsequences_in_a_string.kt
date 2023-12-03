import kotlin.math.max

class Solution {
  fun maximumSubsequenceCount(text: String, pattern: String): Long {
    val cnt = IntArray(26)
    val a = pattern[0]
    val b = pattern[1]
    var ans: Long = 0
    for (c in text.toCharArray()) {
      if (c == b) {
        ans += cnt[a.code - 'a'.code].toLong()
      }
      cnt[c.code - 'a'.code]++
    }
    (ans += max(cnt[a.code - 'a'.code].toDouble(), cnt[b.code - 'a'.code].toDouble())).toLong()
    return ans
  }
}
