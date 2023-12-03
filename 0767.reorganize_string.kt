import kotlin.math.max

internal class Solution {
  fun reorganizeString(s: String): String {
    val cnt = IntArray(26)
    var mx = 0
    for (c in s.toCharArray()) {
      val t = c.code - 'a'.code
      ++cnt[t]
      mx = max(mx.toDouble(), cnt[t].toDouble()).toInt()
    }
    val n = s.length
    if (mx > (n + 1) / 2) {
      return ""
    }
    var k = 0
    for (v in cnt) {
      if (v > 0) {
        ++k
      }
    }
    val m = Array(k) { IntArray(2) }
    k = 0
    for (i in 0..25) {
      if (cnt[i] > 0) {
        m[k++] = intArrayOf(cnt[i], i)
      }
    }
    Arrays.sort(m) { a, b -> b.get(0) - a.get(0) }
    k = 0
    val ans = StringBuilder(s)
    for (e in m) {
      var v = e[0]
      val i = e[1]
      while (v-- > 0) {
        ans.setCharAt(k, ('a'.code + i).toChar())
        k += 2
        if (k >= n) {
          k = 1
        }
      }
    }
    return ans.toString()
  }
}
