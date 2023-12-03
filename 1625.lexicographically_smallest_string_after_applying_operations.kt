class Solution {
  fun findLexSmallestString(s: String, a: Int, b: Int): String {
    var s = s
    val n = s.length
    var ans = s
    for (i in 0 until n) {
      s = s.substring(b) + s.substring(0, b)
      val cs = s.toCharArray()
      for (j in 0..9) {
        var k = 1
        while (k < n) {
          cs[k] = ((cs[k].code - '0'.code + a) % 10 + '0'.code).toChar()
          k += 2
        }
        if (b and 1 == 1) {
          for (p in 0..9) {
            var k = 0
            while (k < n) {
              cs[k] = ((cs[k].code - '0'.code + a) % 10 + '0'.code).toChar()
              k += 2
            }
            s = String(cs)
            if (ans.compareTo(s) > 0) {
              ans = s
            }
          }
        } else {
          s = String(cs)
          if (ans.compareTo(s) > 0) {
            ans = s
          }
        }
      }
    }
    return ans
  }
}
