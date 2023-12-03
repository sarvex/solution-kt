internal class Solution {
  fun lastSubstring(s: String): String {
    val n = s.length
    var i = 0
    var j = 1
    var k = 0
    while (j + k < n) {
      val d = s[i + k].code - s[j + k].code
      if (d == 0) {
        ++k
      } else if (d < 0) {
        i += k + 1
        k = 0
        if (i >= j) {
          j = i + 1
        }
      } else {
        j += k + 1
        k = 0
      }
    }
    return s.substring(i)
  }
}
