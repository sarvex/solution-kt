import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun reformat(s: String): String {
    val a = StringBuilder()
    val b = StringBuilder()
    for (c in s.toCharArray()) {
      if (Character.isDigit(c)) {
        a.append(c)
      } else {
        b.append(c)
      }
    }
    val m = a.length
    val n = b.length
    if (abs((m - n).toDouble()) > 1) {
      return ""
    }
    val ans = StringBuilder()
    for (i in 0 until min(m.toDouble(), n.toDouble()).toInt()) {
      if (m > n) {
        ans.append(a[i])
        ans.append(b[i])
      } else {
        ans.append(b[i])
        ans.append(a[i])
      }
    }
    if (m > n) {
      ans.append(a[m - 1])
    }
    if (m < n) {
      ans.append(b[n - 1])
    }
    return ans.toString()
  }
}
