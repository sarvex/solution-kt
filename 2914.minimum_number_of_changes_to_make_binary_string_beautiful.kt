class Solution {
  fun minChanges(s: String): Int {
    var ans = 0
    var i = 1
    while (i < s.length) {
      if (s[i] != s[i - 1]) {
        ++ans
      }
      i += 2
    }
    return ans
  }
}
