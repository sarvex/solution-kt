internal class Solution {
  fun isPalindrome(s: String): Boolean {
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (!Character.isLetterOrDigit(s[i])) {
        ++i
      } else if (!Character.isLetterOrDigit(s[j])) {
        --j
      } else if (s[i].lowercaseChar() != s[j].lowercaseChar()) {
        return false
      } else {
        ++i
        --j
      }
    }
    return true
  }
}
