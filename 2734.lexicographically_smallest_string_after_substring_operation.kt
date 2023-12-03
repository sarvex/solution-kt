class Solution {
  fun smallestString(s: String): String {
    val n = s.length
    var i = 0
    while (i < n && s[i] == 'a') {
      ++i
    }
    if (i == n) {
      return s.substring(0, n - 1) + "z"
    }
    var j = i
    val cs = s.toCharArray()
    while (j < n && cs[j] != 'a') {
      cs[j] = (cs[j].code - 1).toChar()
      ++j
    }
    return String(cs)
  }
}
