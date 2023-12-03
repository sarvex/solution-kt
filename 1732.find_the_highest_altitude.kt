import kotlin.math.max

class Solution {
  fun largestAltitude(gain: IntArray): Int {
    var ans = 0
    var h = 0
    for (v in gain) {
      h += v
      ans = max(ans.toDouble(), h.toDouble()).toInt()
    }
    return ans
  }
}
