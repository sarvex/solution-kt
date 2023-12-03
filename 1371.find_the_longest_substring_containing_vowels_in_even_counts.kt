import kotlin.math.max
import kotlin.math.min

class Solution {
  fun findTheLongestSubstring(s: String): Int {
    val pos = IntArray(32)
    Arrays.fill(pos, Int.MAX_VALUE)
    pos[0] = -1
    val vowels = "aeiou"
    var state = 0
    var ans = 0
    for (i in 0 until s.length) {
      val c = s[i]
      for (j in 0..4) {
        if (c == vowels[j]) {
          state = state xor (1 shl j)
        }
      }
      ans = max(ans.toDouble(), (i - pos[state]).toDouble()).toInt()
      pos[state] = min(pos[state].toDouble(), i.toDouble()).toInt()
    }
    return ans
  }
}
