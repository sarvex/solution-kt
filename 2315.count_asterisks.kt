class Solution {
  fun countAsterisks(s: String): Int {
    var ans = 0
    var i = 0
    var ok = 1
    while (i < s.length) {
      val c = s[i]
      if (c == '*') {
        ans += ok
      } else if (c == '|') {
        ok = ok xor 1
      }
      ++i
    }
    return ans
  }
}
