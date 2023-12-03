internal class Solution {
  fun validPalindrome(s: String): Boolean {
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (s[i] != s[j]) {
        return check(s, i + 1, j) || check(s, i, j - 1)
      }
      ++i
      --j
    }
    return true
  }

  private fun check(s: String, i: Int, j: Int): Boolean {
    var i = i
    var j = j
    while (i < j) {
      if (s[i] != s[j]) {
        return false
      }
      ++i
      --j
    }
    return true
  }
}
