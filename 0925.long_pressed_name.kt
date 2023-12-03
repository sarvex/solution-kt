internal class Solution {
  fun isLongPressedName(name: String, typed: String): Boolean {
    val m = name.length
    val n = typed.length
    var i = 0
    var j = 0
    while (i < m && j < n) {
      if (name[i] != typed[j]) {
        return false
      }
      var cnt1 = 0
      var cnt2 = 0
      val c = name[i]
      while (i + 1 < m && name[i + 1] == c) {
        ++i
        ++cnt1
      }
      while (j + 1 < n && typed[j + 1] == c) {
        ++j
        ++cnt2
      }
      if (cnt1 > cnt2) {
        return false
      }
      ++i
      ++j
    }
    return i == m && j == n
  }
}
