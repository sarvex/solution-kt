internal class Solution {
  fun monotoneIncreasingDigits(n: Int): Int {
    val s = n.toString().toCharArray()
    var i = 1
    while (i < s.size && s[i - 1] <= s[i]) {
      ++i
    }
    if (i < s.size) {
      while (i > 0 && s[i - 1] > s[i]) {
        --s[i - 1]
        --i
      }
      ++i
      while (i < s.size) {
        s[i] = '9'
        ++i
      }
    }
    return String(s).toInt()
  }
}
