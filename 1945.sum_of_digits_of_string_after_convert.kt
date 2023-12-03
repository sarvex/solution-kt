class Solution {
  fun getLucky(s: String, k: Int): Int {
    var s = s
    var k = k
    val sb = StringBuilder()
    for (c in s.toCharArray()) {
      sb.append(c.code - 'a'.code + 1)
    }
    s = sb.toString()
    while (k-- > 0) {
      var t = 0
      for (c in s.toCharArray()) {
        t += c.code - '0'.code
      }
      s = t.toString()
    }
    return s.toInt()
  }
}
