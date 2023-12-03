import kotlin.math.abs
import kotlin.math.max

internal class Solution {
  fun largestTriangleArea(points: Array<IntArray>): Double {
    var ans = 0.0
    for (p1 in points) {
      val x1 = p1[0]
      val y1 = p1[1]
      for (p2 in points) {
        val x2 = p2[0]
        val y2 = p2[1]
        for (p3 in points) {
          val x3 = p3[0]
          val y3 = p3[1]
          val u1 = x2 - x1
          val v1 = y2 - y1
          val u2 = x3 - x1
          val v2 = y3 - y1
          val t = abs((u1 * v2 - u2 * v1).toDouble()) / 2.0
          ans = max(ans, t)
        }
      }
    }
    return ans
  }
}
