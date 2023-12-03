import kotlin.math.atan2
import kotlin.math.max

class Solution {
  fun visiblePoints(points: List<List<Int>>, angle: Int, location: List<Int>): Int {
    val v: List<Double> = ArrayList()
    val x = location[0]
    val y = location[1]
    var same = 0
    for (p in points) {
      val xi = p[0]
      val yi = p[1]
      if (xi == x && yi == y) {
        ++same
        continue
      }
      v.add(atan2((yi - y).toDouble(), (xi - x).toDouble()))
    }
    Collections.sort(v)
    val n: Int = v.size()
    for (i in 0 until n) {
      v.add(v[i] + 2 * Math.PI)
    }
    var mx = 0
    val t = angle * Math.PI / 180
    var i = 0
    var j = 0
    while (j < 2 * n) {
      while (i < j && v[j] - v[i] > t) {
        ++i
      }
      mx = max(mx.toDouble(), (j - i + 1).toDouble()).toInt()
      ++j
    }
    return mx + same
  }
}
