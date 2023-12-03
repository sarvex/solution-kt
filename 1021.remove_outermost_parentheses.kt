internal class Solution {
  fun removeOuterParentheses(s: String): String {
    val ans = StringBuilder()
    var cnt = 0
    for (i in 0 until s.length) {
      val c = s[i]
      if (c == '(') {
        if (++cnt > 1) {
          ans.append(c)
        }
      } else {
        if (--cnt > 0) {
          ans.append(c)
        }
      }
    }
    return ans.toString()
  }
}
