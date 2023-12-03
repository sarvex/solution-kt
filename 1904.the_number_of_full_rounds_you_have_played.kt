import kotlin.math.max

class Solution {
  fun numberOfRounds(startTime: String, finishTime: String): Int {
    var start = get(startTime)
    var finish = get(finishTime)
    if (start > finish) {
      finish += 24 * 60
    }
    start = (start + 14) / 15
    finish /= 15
    return max(0.0, (finish - start).toDouble()).toInt()
  }

  private operator fun get(s: String): Int {
    return s.substring(0, 2).toInt() * 60 + s.substring(3).toInt()
  }
}
