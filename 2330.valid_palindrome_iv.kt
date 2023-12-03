class Solution {
  fun makePalindrome(s: String): Boolean {
    var cnt = 0
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (s[i] != s[j]) {
        ++cnt
      }
      ++i
      --j
    }
    return cnt <= 2
  }
}
