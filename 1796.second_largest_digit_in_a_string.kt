class Solution {
  fun secondHighest(s: String): Int {
    var a = -1
    var b = -1
    for (i in 0 until s.length) {
      val c = s[i]
      if (Character.isDigit(c)) {
        val v = c.code - '0'.code
        if (v > a) {
          b = a
          a = v
        } else if (v > b && v < a) {
          b = v
        }
      }
    }
    return b
  }
}
