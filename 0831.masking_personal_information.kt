import java.util.*

internal class Solution {
  fun maskPII(s: String): String {
    var s = s
    if (Character.isLetter(s[0])) {
      s = s.lowercase(Locale.getDefault())
      val i = s.indexOf('@')
      return s.substring(0, 1) + "*****" + s.substring(i - 1)
    }
    val sb = StringBuilder()
    for (c in s.toCharArray()) {
      if (Character.isDigit(c)) {
        sb.append(c)
      }
    }
    s = sb.toString()
    val cnt = s.length - 10
    val suf = "***-***-" + s.substring(s.length - 4)
    return if (cnt == 0) suf else ("+"
        + "*".repeat(cnt) + "-" + suf)
  }
}
