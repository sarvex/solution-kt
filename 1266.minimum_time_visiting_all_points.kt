import kotlin.math.abs
import kotlin.math.max

internal class Solution {
  fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var ans = 0
    for (i in 1 until points.size) {
      val dx = abs((points[i][0] - points[i - 1][0]).toDouble()).toInt()
      val dy = abs((points[i][1] - points[i - 1][1]).toDouble()).toInt()
      (ans += max(dx.toDouble(), dy.toDouble())).toInt()
    }
    return ans
  }
}
