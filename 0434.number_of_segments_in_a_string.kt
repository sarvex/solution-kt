internal class Solution {
  fun countSegments(s: String): Int {
    var ans = 0
    for (i in 0 until s.length) {
      if (s[i] != ' ' && (i == 0 || s[i - 1] == ' ')) {
        ++ans
      }
    }
    return ans
  }
}
