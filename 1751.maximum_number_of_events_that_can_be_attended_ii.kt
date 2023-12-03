import kotlin.math.max

class Solution {
  fun maxValue(events: Array<IntArray>, k: Int): Int {
    Arrays.sort(events) { a, b -> a.get(1) - b.get(1) }
    val n = events.size
    val f = Array(n + 1) { IntArray(k + 1) }
    for (i in 1..n) {
      val st = events[i - 1][0]
      val `val` = events[i - 1][2]
      val p = search(events, st, i - 1)
      for (j in 1..k) {
        f[i][j] = max(f[i - 1][j].toDouble(), (f[p][j - 1] + `val`).toDouble())
          .toInt()
      }
    }
    return f[n][k]
  }

  private fun search(events: Array<IntArray>, x: Int, hi: Int): Int {
    var l = 0
    var r = hi
    while (l < r) {
      val mid = l + r shr 1
      if (events[mid][1] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
