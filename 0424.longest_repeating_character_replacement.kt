import kotlin.math.max

internal class Solution {
  fun characterReplacement(s: String, k: Int): Int {
    val counter = IntArray(26)
    var i = 0
    var j = 0
    var maxCnt = 0
    while (i < s.length) {
      val c = s[i]
      ++counter[c.code - 'A'.code]
      maxCnt = max(maxCnt.toDouble(), counter[c.code - 'A'.code].toDouble()).toInt()
      if (i - j + 1 - maxCnt > k) {
        --counter[s[j].code - 'A'.code]
        ++j
      }
      ++i
    }
    return i - j
  }
}
