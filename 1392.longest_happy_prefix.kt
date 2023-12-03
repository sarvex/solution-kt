class Solution {
  private var p: LongArray
  private var h: LongArray
  fun longestPrefix(s: String): String {
    val base = 131
    val n = s.length
    p = LongArray(n + 10)
    h = LongArray(n + 10)
    p[0] = 1
    for (i in 0 until n) {
      p[i + 1] = p[i] * base
      h[i + 1] = h[i] * base + s[i].code.toLong()
    }
    for (l in n - 1 downTo 1) {
      if (get(1, l) == get(n - l + 1, n)) {
        return s.substring(0, l)
      }
    }
    return ""
  }

  private operator fun get(l: Int, r: Int): Long {
    return h[r] - h[l - 1] * p[r - l + 1]
  }
}
