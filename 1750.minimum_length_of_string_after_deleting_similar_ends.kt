import kotlin.math.max

class Solution {
  fun minimumLength(s: String): Int {
    var i = 0
    var j = s.length - 1
    while (i < j && s[i] == s[j]) {
      while (i + 1 < j && s[i] == s[i + 1]) {
        ++i
      }
      while (i < j - 1 && s[j] == s[j - 1]) {
        --j
      }
      ++i
      --j
    }
    return max(0.0, (j - i + 1).toDouble()).toInt()
  }
}
