import kotlin.math.max

class Solution {
  fun maximumValue(strs: Array<String>): Int {
    var ans = 0
    for (s in strs) {
      ans = max(ans.toDouble(), f(s).toDouble()).toInt()
    }
    return ans
  }

  private fun f(s: String): Int {
    var x = 0
    var i = 0
    val n = s.length
    while (i < n) {
      val c = s[i]
      if (Character.isLetter(c)) {
        return n
      }
      x = x * 10 + (c.code - '0'.code)
      ++i
    }
    return x
  }
}
