import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minMaxGame(nums: IntArray): Int {
    var n = nums.size
    while (n > 1) {
      n = n shr 1
      for (i in 0 until n) {
        val a = nums[i shl 1]
        val b = nums[i shl 1 or 1]
        nums[i] = if (i % 2 == 0) min(a.toDouble(), b.toDouble()).toInt() else max(a.toDouble(), b.toDouble())
          .toInt()
      }
    }
    return nums[0]
  }
}
