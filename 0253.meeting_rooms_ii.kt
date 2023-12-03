import kotlin.math.max

internal class Solution {
  fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val n = 1000010
    val delta = IntArray(n)
    for (e in intervals) {
      ++delta[e[0]]
      --delta[e[1]]
    }
    var res = delta[0]
    for (i in 1 until n) {
      delta[i] += delta[i - 1]
      res = max(res.toDouble(), delta[i].toDouble()).toInt()
    }
    return res
  }
}
