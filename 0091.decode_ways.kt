internal class Solution {
  fun numDecodings(s: String): Int {
    val n = s.length
    var f = 0
    var g = 1
    for (i in 1..n) {
      var h = if (s[i - 1] != '0') g else 0
      if (i > 1 && s[i - 2] != '0' && s.substring(i - 2, i).toInt() <= 26) {
        h += f
      }
      f = g
      g = h
    }
    return g
  }
}
