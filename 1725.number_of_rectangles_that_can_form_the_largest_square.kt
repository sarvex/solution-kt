import kotlin.math.min

class Solution {
  fun countGoodRectangles(rectangles: Array<IntArray>): Int {
    var ans = 0
    var mx = 0
    for (r in rectangles) {
      val t = min(r[0].toDouble(), r[1].toDouble()).toInt()
      if (mx < t) {
        mx = t
        ans = 1
      } else if (mx == t) {
        ++ans
      }
    }
    return ans
  }
}
