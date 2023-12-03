import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minStartValue(nums: IntArray): Int {
    var s = 0
    var t = Int.MAX_VALUE
    for (num in nums) {
      s += num
      t = min(t.toDouble(), s.toDouble()).toInt()
    }
    return max(1.0, (1 - t).toDouble()).toInt()
  }
}
