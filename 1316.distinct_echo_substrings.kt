class Solution {
  private var h: LongArray
  private var p: LongArray
  fun distinctEchoSubstrings(text: String): Int {
    val n = text.length
    val base = 131
    h = LongArray(n + 10)
    p = LongArray(n + 10)
    p[0] = 1
    for (i in 0 until n) {
      val t = text[i].code - 'a'.code + 1
      h[i + 1] = h[i] * base + t
      p[i + 1] = p[i] * base
    }
    val vis: Set<Long> = HashSet()
    for (i in 0 until n - 1) {
      var j = i + 1
      while (j < n) {
        val k = i + j shr 1
        val a = get(i + 1, k + 1)
        val b = get(k + 2, j + 1)
        if (a == b) {
          vis.add(a)
        }
        j += 2
      }
    }
    return vis.size()
  }

  private operator fun get(i: Int, j: Int): Long {
    return h[j] - h[i - 1] * p[j - i + 1]
  }
}
