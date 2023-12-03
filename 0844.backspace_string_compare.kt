internal class Solution {
  fun backspaceCompare(s: String, t: String): Boolean {
    var i = s.length - 1
    var j = t.length - 1
    var skip1 = 0
    var skip2 = 0
    while (i >= 0 || j >= 0) {
      while (i >= 0) {
        if (s[i] == '#') {
          ++skip1
          --i
        } else if (skip1 > 0) {
          --skip1
          --i
        } else {
          break
        }
      }
      while (j >= 0) {
        if (t[j] == '#') {
          ++skip2
          --j
        } else if (skip2 > 0) {
          --skip2
          --j
        } else {
          break
        }
      }
      if (i >= 0 && j >= 0) {
        if (s[i] != t[j]) {
          return false
        }
      } else if (i >= 0 || j >= 0) {
        return false
      }
      --i
      --j
    }
    return true
  }
}
