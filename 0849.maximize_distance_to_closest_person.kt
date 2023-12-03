import kotlin.math.max

internal class Solution {
  fun maxDistToClosest(seats: IntArray): Int {
    var first = -1
    var last = -1
    var d = 0
    val n = seats.size
    for (i in 0 until n) {
      if (seats[i] == 1) {
        if (last != -1) {
          d = max(d.toDouble(), (i - last).toDouble()).toInt()
        }
        if (first == -1) {
          first = i
        }
        last = i
      }
    }
    return max((d / 2).toDouble(), max(first.toDouble(), (n - last - 1).toDouble())).toInt()
  }
}
