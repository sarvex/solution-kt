internal class Solution {
  fun scoreOfParentheses(s: String): Int {
    var ans = 0
    var d = 0
    for (i in 0 until s.length) {
      if (s[i] == '(') {
        ++d
      } else {
        --d
        if (s[i - 1] == '(') {
          ans += 1 shl d
        }
      }
    }
    return ans
  }
}
