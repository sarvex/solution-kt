class Solution {
  fun removePalindromeSub(s: String): Int {
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (s[i] != s[j]) {
        return 2
      }
      ++i
      --j
    }
    return 1
  }
}
