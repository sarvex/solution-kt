class Solution {
  fun minimumMoves(s: String): Int {
    var ans = 0
    var i = 0
    while (i < s.length) {
      if (s[i] == 'X') {
        ++ans
        i += 2
      }
      ++i
    }
    return ans
  }
}
