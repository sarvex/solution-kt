internal class Solution {
  fun myAtoi(s: String?): Int {
    if (s == null) return 0
    val n = s.length
    if (n == 0) return 0
    var i = 0
    while (s[i] == ' ') {
      if (++i == n) return 0
    }
    var sign = 1
    if (s[i] == '-') sign = -1
    if (s[i] == '-' || s[i] == '+') ++i
    var res = 0
    val flag = Int.MAX_VALUE / 10
    for (j in i until n) {
      if (s[j] < '0' || s[j] > '9') break
      if (res > flag || res == flag && s[j] > '7') return if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE
      res = res * 10 + (s[j].code - '0'.code)
    }
    return sign * res
  }
}
