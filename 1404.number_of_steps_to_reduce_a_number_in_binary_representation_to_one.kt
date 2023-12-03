class Solution {
  fun numSteps(s: String): Int {
    var carry = false
    var ans = 0
    for (i in s.length - 1 downTo 1) {
      var c = s[i]
      if (carry) {
        if (c == '0') {
          c = '1'
          carry = false
        } else {
          c = '0'
        }
      }
      if (c == '1') {
        ++ans
        carry = true
      }
      ++ans
    }
    if (carry) {
      ++ans
    }
    return ans
  }
}
