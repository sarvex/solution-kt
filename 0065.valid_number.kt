internal class Solution {
  fun isNumber(s: String): Boolean {
    val n = s.length
    var i = 0
    if (s[i] == '+' || s[i] == '-') {
      ++i
    }
    if (i == n) {
      return false
    }
    if (s[i] == '.'
      && (i + 1 == n || s[i + 1] == 'e' || s[i + 1] == 'E')
    ) {
      return false
    }
    var dot = 0
    var e = 0
    var j = i
    while (j < n) {
      if (s[j] == '.') {
        if (e > 0 || dot > 0) {
          return false
        }
        ++dot
      } else if (s[j] == 'e' || s[j] == 'E') {
        if (e > 0 || j == i || j == n - 1) {
          return false
        }
        ++e
        if (s[j + 1] == '+' || s[j + 1] == '-') {
          if (++j == n - 1) {
            return false
          }
        }
      } else if (s[j] < '0' || s[j] > '9') {
        return false
      }
      ++j
    }
    return true
  }
}
