internal class Solution {
  fun countLetters(s: String): Int {
    var ans = 0
    var i = 0
    val n = s.length
    while (i < n) {
      var j = i
      while (j < n && s[j] == s[i]) {
        ++j
      }
      ans += (1 + j - i) * (j - i) / 2
      i = j
    }
    return ans
  }
}
