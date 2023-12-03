class Solution {
  fun findTheString(lcp: Array<IntArray>): String {
    val n = lcp.size
    val s = CharArray(n)
    var i = 0
    var c = 'a'
    while (c <= 'z') {
      while (i < n && s[i] != '\u0000') {
        ++i
      }
      if (i == n) {
        break
      }
      for (j in i until n) {
        if (lcp[i][j] > 0) {
          s[j] = c
        }
      }
      ++c
    }
    i = 0
    while (i < n) {
      if (s[i] == '\u0000') {
        return ""
      }
      ++i
    }
    i = n - 1
    while (i >= 0) {
      for (j in n - 1 downTo 0) {
        if (s[i] == s[j]) {
          if (i == n - 1 || j == n - 1) {
            if (lcp[i][j] != 1) {
              return ""
            }
          } else if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
            return ""
          }
        } else if (lcp[i][j] > 0) {
          return ""
        }
      }
      --i
    }
    return String(s)
  }
}
