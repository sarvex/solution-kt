import kotlin.math.max

class Solution {
  fun maxScoreSightseeingPair(values: IntArray): Int {
    var ans = 0
    var mx = values[0]
    for (j in 1 until values.size) {
      ans = max(ans.toDouble(), (values[j] - j + mx).toDouble()).toInt()
      mx = max(mx.toDouble(), (values[j] + j).toDouble()).toInt()
    }
    return ans
  }
}
