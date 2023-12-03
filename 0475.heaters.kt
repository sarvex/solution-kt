import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun findRadius(houses: IntArray, heaters: IntArray): Int {
    Arrays.sort(heaters)
    var res = 0
    for (x in houses) {
      var i: Int = Arrays.binarySearch(heaters, x)
      if (i < 0) {
        i = i.inv()
      }
      val dis1 = if (i > 0) x - heaters[i - 1] else Int.MAX_VALUE
      val dis2 = if (i < heaters.size) heaters[i] - x else Int.MAX_VALUE
      res = max(res.toDouble(), min(dis1.toDouble(), dis2.toDouble())).toInt()
    }
    return res
  }
}
