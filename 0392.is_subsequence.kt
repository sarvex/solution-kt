internal class Solution {
  fun isSubsequence(s: String, t: String): Boolean {
    val m = s.length
    val n = t.length
    var i = 0
    var j = 0
    while (i < m && j < n) {
      if (s[i] == t[j]) {
        ++i
      }
      ++j
    }
    return i == m
  }
}
