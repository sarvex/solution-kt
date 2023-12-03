import kotlin.math.min

class Solution {
  fun digitSum(s: String, k: Int): String {
    var s = s
    while (s.length > k) {
      val n = s.length
      val t = StringBuilder()
      var i = 0
      while (i < n) {
        var x = 0
        for (j in i until min((i + k).toDouble(), n.toDouble()).toInt()) {
          x += s[j].code - '0'.code
        }
        t.append(x)
        i += k
      }
      s = t.toString()
    }
    return s
  }
}
