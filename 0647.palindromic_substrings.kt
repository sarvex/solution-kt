import kotlin.math.min

internal class Solution {
  fun countSubstrings(s: String): Int {
    val sb = StringBuilder("^#")
    for (ch in s.toCharArray()) {
      sb.append(ch).append('#')
    }
    val t = sb.append('$').toString()
    val n = t.length
    val p = IntArray(n)
    var pos = 0
    var maxRight = 0
    var ans = 0
    for (i in 1 until n - 1) {
      p[i] = if (maxRight > i) min((maxRight - i).toDouble(), p[2 * pos - i].toDouble()).toInt() else 1
      while (t[i - p[i]] == t[i + p[i]]) {
        p[i]++
      }
      if (i + p[i] > maxRight) {
        maxRight = i + p[i]
        pos = i
      }
      ans += p[i] / 2
    }
    return ans
  }
}
