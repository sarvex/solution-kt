internal class Solution {
  fun canBeValid(s: String, locked: String): Boolean {
    val n = s.length
    if (n % 2 == 1) {
      return false
    }
    var x = 0
    for (i in 0 until n) {
      if (s[i] == '(' || locked[i] == '0') {
        ++x
      } else if (x > 0) {
        --x
      } else {
        return false
      }
    }
    x = 0
    for (i in n - 1 downTo 0) {
      if (s[i] == ')' || locked[i] == '0') {
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
