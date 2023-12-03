internal class Solution {
  fun expressiveWords(s: String, words: Array<String>): Int {
    var ans = 0
    for (t in words) {
      if (check(s, t)) {
        ++ans
      }
    }
    return ans
  }

  private fun check(s: String, t: String): Boolean {
    val m = s.length
    val n = t.length
    if (n > m) {
      return false
    }
    var i = 0
    var j = 0
    while (i < m && j < n) {
      if (s[i] != t[j]) {
        return false
      }
      var k = i
      while (k < m && s[k] == s[i]) {
        ++k
      }
      val c1 = k - i
      i = k
      k = j
      while (k < n && t[k] == t[j]) {
        ++k
      }
      val c2 = k - j
      j = k
      if (c1 < c2 || c1 < 3 && c1 != c2) {
        return false
      }
    }
    return i == m && j == n
  }
}
