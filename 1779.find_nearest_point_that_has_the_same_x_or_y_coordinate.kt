import kotlin.math.abs

class Solution {
  fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
    var ans = -1
    var mi = 1000000
    for (i in points.indices) {
      val a = points[i][0]
      val b = points[i][1]
      if (a == x || b == y) {
        val d = (abs((a - x).toDouble()) + abs((b - y).toDouble())).toInt()
        if (d < mi) {
          mi = d
          ans = i
        }
      }
    }
    return ans
  }
}
