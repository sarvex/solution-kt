internal class Solution {
  fun validWordAbbreviation(word: String, abbr: String): Boolean {
    val m = word.length
    val n = abbr.length
    var i = 0
    var j = 0
    var x = 0
    while (i < m && j < n) {
      val c = abbr[j]
      if (Character.isDigit(c)) {
        if (c == '0' && x == 0) {
          return false
        }
        x = x * 10 + (c.code - '0'.code)
      } else {
        i += x
        x = 0
        if (i >= m || word[i] != c) {
          return false
        }
        ++i
      }
      ++j
    }
    return i + x == m && j == n
  }
}
