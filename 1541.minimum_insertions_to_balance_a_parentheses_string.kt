class Solution {
  fun minInsertions(s: String): Int {
    var ans = 0
    var x = 0
    val n = s.length
    var i = 0
    while (i < n) {
      if (s[i] == '(') {
        ++x
      } else {
        if (i < n - 1 && s[i + 1] == ')') {
          ++i
        } else {
          ++ans
        }
        if (x == 0) {
          ++ans
        } else {
          --x
        }
      }
      ++i
    }
    ans += x shl 1
    return ans
  }
}
