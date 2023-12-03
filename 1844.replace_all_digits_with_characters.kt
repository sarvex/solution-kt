class Solution {
  fun replaceDigits(s: String): String {
    val cs = s.toCharArray()
    var i = 1
    while (i < cs.size) {
      cs[i] = (cs[i - 1].code + (cs[i].code - '0'.code)).toChar()
      i += 2
    }
    return String(cs)
  }
}
