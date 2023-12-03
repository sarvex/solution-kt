import kotlin.math.sqrt

internal class Solution {
  fun constructRectangle(area: Int): IntArray {
    var w = sqrt(area.toDouble()).toInt()
    while (area % w != 0) {
      --w
    }
    return intArrayOf(area / w, w)
  }
}
