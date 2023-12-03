import kotlin.math.max

class Solution {
  fun maxVowels(s: String, k: Int): Int {
    var t = 0
    val n = s.length
    for (i in 0 until k) {
      if (isVowel(s[i])) {
        ++t
      }
    }
    var ans = t
    for (i in k until n) {
      if (isVowel(s[i])) {
        ++t
      }
      if (isVowel(s[i - k])) {
        --t
      }
      ans = max(ans.toDouble(), t.toDouble()).toInt()
    }
    return ans
  }

  private fun isVowel(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
  }
}
