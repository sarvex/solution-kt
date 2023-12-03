internal class Solution {
  fun camelMatch(queries: Array<String>, pattern: String): List<Boolean> {
    val ans: List<Boolean> = ArrayList()
    for (q in queries) {
      ans.add(check(q, pattern))
    }
    return ans
  }

  private fun check(s: String, t: String): Boolean {
    val m = s.length
    val n = t.length
    var i = 0
    var j = 0
    while (j < n) {
      while (i < m && s[i] != t[j] && Character.isLowerCase(s[i])) {
        ++i
      }
      if (i == m || s[i] != t[j]) {
        return false
      }
      ++i
      ++j
    }
    while (i < m && Character.isLowerCase(s[i])) {
      ++i
    }
    return i == m
  }
}
