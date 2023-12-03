internal class Solution {
  fun decodeAtIndex(s: String, k: Int): String {
    var k = k
    var m: Long = 0
    for (i in 0 until s.length) {
      if (Character.isDigit(s[i])) {
        m *= (s[i].code - '0'.code).toLong()
      } else {
        ++m
      }
    }
    var i = s.length - 1
    while (true) {
      k %= m.toInt()
      if (k == 0 && !Character.isDigit(s[i])) {
        return s[i].toString()
      }
      if (Character.isDigit(s[i])) {
        m /= (s[i].code - '0'.code).toLong()
      } else {
        --m
      }
      --i
    }
  }
}
