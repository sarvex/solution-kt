internal class Solution {
  private var p: LongArray
  private var h: LongArray
  fun longestDupSubstring(s: String): String {
    val base = 131
    val n = s.length
    p = LongArray(n + 10)
    h = LongArray(n + 10)
    p[0] = 1
    for (i in 0 until n) {
      p[i + 1] = p[i] * base
      h[i + 1] = h[i] * base + s[i].code.toLong()
    }
    var ans = ""
    var left = 0
    var right = n
    while (left < right) {
      val mid = left + right + 1 shr 1
      val t = check(s, mid)
      if (t.length > 0) {
        left = mid
        ans = t
      } else {
        right = mid - 1
      }
    }
    return ans
  }

  private fun check(s: String, len: Int): String {
    val n = s.length
    val vis: Set<Long> = HashSet()
    var i = 1
    while (i + len - 1 <= n) {
      val j = i + len - 1
      val t = h[j] - h[i - 1] * p[j - i + 1]
      if (vis.contains(t)) {
        return s.substring(i - 1, j)
      }
      vis.add(t)
      ++i
    }
    return ""
  }
}
