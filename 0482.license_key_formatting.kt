import java.util.*

internal class Solution {
  fun licenseKeyFormatting(s: String, k: Int): String {
    var s = s
    s = s.replace("-", "").uppercase(Locale.getDefault())
    val sb = StringBuilder()
    var t = 0
    var cnt = s.length % k
    if (cnt == 0) {
      cnt = k
    }
    for (i in 0 until s.length) {
      sb.append(s[i])
      ++t
      if (t == cnt) {
        t = 0
        cnt = k
        if (i != s.length - 1) {
          sb.append('-')
        }
      }
    }
    return sb.toString()
  }
}
