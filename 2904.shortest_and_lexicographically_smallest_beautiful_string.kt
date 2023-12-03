class Solution {
  fun shortestBeautifulSubstring(s: String, k: Int): String {
    var i = 0
    var j = 0
    var cnt = 0
    val n = s.length
    var ans = ""
    while (j < n) {
      cnt += s[j].code - '0'.code
      while (cnt > k || i < j && s[i] == '0') {
        cnt -= s[i].code - '0'.code
        ++i
      }
      ++j
      val t = s.substring(i, j)
      if (cnt == k
        && ("" == ans || j - i < ans.length || j - i == ans.length && t.compareTo(ans) < 0)
      ) {
        ans = t
      }
    }
    return ans
  }
}
