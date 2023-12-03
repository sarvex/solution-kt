import kotlin.math.abs
import kotlin.math.sqrt

class Solution {
  fun getMinDistSum(positions: Array<IntArray>): Double {
    val n = positions.size
    var x = 0.0
    var y = 0.0
    for (p in positions) {
      x += p[0].toDouble()
      y += p[1].toDouble()
    }
    x /= n.toDouble()
    y /= n.toDouble()
    val decay = 0.999
    val eps = 1e-6
    var alpha = 0.5
    while (true) {
      var gradX = 0.0
      var gradY = 0.0
      var dist = 0.0
      for (p in positions) {
        val a = x - p[0]
        val b = y - p[1]
        val c = sqrt(a * a + b * b)
        gradX += a / (c + 1e-8)
        gradY += b / (c + 1e-8)
        dist += c
      }
      val dx = gradX * alpha
      val dy = gradY * alpha
      if (abs(dx) <= eps && abs(dy) <= eps) {
        return dist
      }
      x -= dx
      y -= dy
      alpha *= decay
    }
  }
}
