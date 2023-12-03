internal class Solution {
  fun checkValidString(s: String): Boolean {
    var x = 0
    val n = s.length
    for (i in 0 until n) {
      if (s[i] != ')') {
        ++x
      } else if (x > 0) {
        --x
      } else {
        return false
      }
    }
    x = 0
    for (i in n - 1 downTo 0) {
      if (s[i] != '(') {
        ++x
      } else if (x > 0) {
        --x
      } else {
        return false
      }
    }
    return true
  }
}
