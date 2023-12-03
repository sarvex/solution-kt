internal class Solution {
  fun countBinarySubstrings(s: String): Int {
    var i = 0
    val n = s.length
    val t: List<Int> = ArrayList()
    while (i < n) {
      var cnt = 1
      while (i + 1 < n && s[i + 1] == s[i]) {
        ++i
        ++cnt
      }
      t.add(cnt)
      ++i
    }
    var ans = 0
    i = 1
    while (i < t.size()) {
      ans += Math.min(t[i - 1], t[i])
      ++i
    }
    return ans
  }
}
