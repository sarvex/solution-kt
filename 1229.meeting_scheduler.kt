import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
    Arrays.sort(slots1) { a, b -> a.get(0) - b.get(0) }
    Arrays.sort(slots2) { a, b -> a.get(0) - b.get(0) }
    val m = slots1.size
    val n = slots2.size
    var i = 0
    var j = 0
    while (i < m && j < n) {
      val start = max(slots1[i][0].toDouble(), slots2[j][0].toDouble()).toInt()
      val end = min(slots1[i][1].toDouble(), slots2[j][1].toDouble()).toInt()
      if (end - start >= duration) {
        return Arrays.asList(start, start + duration)
      }
      if (slots1[i][1] < slots2[j][1]) {
        ++i
      } else {
        ++j
      }
    }
    return Collections.emptyList()
  }
}
