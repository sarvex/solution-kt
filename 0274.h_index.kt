import kotlin.math.min

internal class Solution {
  fun hIndex(citations: IntArray): Int {
    val n = citations.size
    val cnt = IntArray(n + 1)
    for (x in citations) {
      ++cnt[min(x.toDouble(), n.toDouble()).toInt()]
    }
    var h = n
    var s = 0
    while (true) {
      s += cnt[h]
      if (s >= h) {
        return h
      }
      --h
    }
  }
}
