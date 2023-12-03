import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun angleClock(hour: Int, minutes: Int): Double {
    val h = 30 * hour + 0.5 * minutes
    val m = (6 * minutes).toDouble()
    val diff = abs(h - m)
    return min(diff, 360 - diff)
  }
}
