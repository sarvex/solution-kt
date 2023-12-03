import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun partitionDisjoint(nums: IntArray): Int {
    val n = nums.size
    val mi = IntArray(n + 1)
    mi[n] = nums[n - 1]
    for (i in n - 1 downTo 0) {
      mi[i] = min(nums[i].toDouble(), mi[i + 1].toDouble()).toInt()
    }
    var mx = 0
    for (i in 1..n) {
      val v = nums[i - 1]
      mx = max(mx.toDouble(), v.toDouble()).toInt()
      if (mx <= mi[i]) {
        return i
      }
    }
    return 0
  }
}
