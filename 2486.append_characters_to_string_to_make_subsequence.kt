class Solution {
  fun appendCharacters(s: String, t: String): Int {
    val m = s.length
    val n = t.length
    var i = 0
    var j = 0
    while (j < n) {
      while (i < m && s[i] != t[j]) {
        ++i
      }
      if (i++ == m) {
        return n - j
      }
      ++j
    }
    return 0
  }
}
