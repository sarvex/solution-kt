import kotlin.math.min

internal class Solution {
  fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    val n = timeSeries.size
    var ans = duration
    for (i in 1 until n) {
      (ans += min(duration.toDouble(), (timeSeries[i] - timeSeries[i - 1]).toDouble())).toInt()
    }
    return ans
  }
}
