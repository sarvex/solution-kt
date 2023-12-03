internal class Solution {
  fun isOneEditDistance(s: String, t: String): Boolean {
    val m = s.length
    val n = t.length
    if (m < n) {
      return isOneEditDistance(t, s)
    }
    if (m - n > 1) {
      return false
    }
    for (i in 0 until n) {
      if (s[i] != t[i]) {
        return if (m == n) {
          s.substring(i + 1) == t.substring(i + 1)
        } else s.substring(i + 1) == t.substring(i)
      }
    }
    return m == n + 1
  }
}
