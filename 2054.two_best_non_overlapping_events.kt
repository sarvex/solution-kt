import kotlin.math.max

internal class Solution {
  fun maxTwoEvents(events: Array<IntArray>): Int {
    Arrays.sort(events) { a, b -> a.get(0) - b.get(0) }
    val n = events.size
    val f = IntArray(n + 1)
    for (i in n - 1 downTo 0) {
      f[i] = max(f[i + 1].toDouble(), events[i][2].toDouble()).toInt()
    }
    var ans = 0
    for (e in events) {
      var v = e[2]
      var left = 0
      var right = n
      while (left < right) {
        val mid = left + right shr 1
        if (events[mid][0] > e[1]) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      if (left < n) {
        v += f[left]
      }
      ans = max(ans.toDouble(), v.toDouble()).toInt()
    }
    return ans
  }
}
