import kotlin.math.min

internal class Solution {
  fun reverseStr(s: String, k: Int): String {
    val chars = s.toCharArray()
    var i = 0
    while (i < chars.size) {
      var st = i
      var ed = min((chars.size - 1).toDouble(), (i + k - 1).toDouble()).toInt()
      while (st < ed) {
        val t = chars[st]
        chars[st] = chars[ed]
        chars[ed] = t
        ++st
        --ed
      }
      i += k shl 1
    }
    return String(chars)
  }
}
