import kotlin.math.abs

class Solution {
  fun makeGood(s: String): String {
    val sb = StringBuilder()
    for (c in s.toCharArray()) {
      if (sb.length == 0 || abs((sb[sb.length - 1].code - c.code).toDouble()) != 32) {
        sb.append(c)
      } else {
        sb.deleteCharAt(sb.length - 1)
      }
    }
    return sb.toString()
  }
}
