import kotlin.math.min
import kotlin.math.sqrt

class Solution {
  fun minAreaFreeRect(points: Array<IntArray>): Double {
    val n = points.size
    val s: Set<Int> = HashSet(n)
    for (p in points) {
      s.add(f(p[0], p[1]))
    }
    var ans = Double.MAX_VALUE
    for (i in 0 until n) {
      val x1 = points[i][0]
      val y1 = points[i][1]
      for (j in 0 until n) {
        if (j != i) {
          val x2 = points[j][0]
          val y2 = points[j][1]
          for (k in j + 1 until n) {
            if (k != i) {
              val x3 = points[k][0]
              val y3 = points[k][1]
              val x4 = x2 - x1 + x3
              val y4 = y2 - y1 + y3
              if (s.contains(f(x4, y4))) {
                if ((x2 - x1) * (x3 - x1) + (y2 - y1) * (y3 - y1) == 0) {
                  val ww = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)
                  val hh = (x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1)
                  ans = min(ans, sqrt((1L * ww * hh).toDouble()))
                }
              }
            }
          }
        }
      }
    }
    return if (ans == Double.MAX_VALUE) 0 else ans
  }

  private fun f(x: Int, y: Int): Int {
    return x * 40001 + y
  }
}
