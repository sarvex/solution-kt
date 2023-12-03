class Solution {
  fun isDecomposable(s: String): Boolean {
    var i = 0
    val n = s.length
    var cnt2 = 0
    while (i < n) {
      var j = i
      while (j < n && s[j] == s[i]) {
        ++j
      }
      if ((j - i) % 3 == 1) {
        return false
      }
      if ((j - i) % 3 == 2 && ++cnt2 > 1) {
        return false
      }
      i = j
    }
    return cnt2 == 1
  }
}
