import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxProduct(nums: IntArray): Int {
    var f = nums[0]
    var g = nums[0]
    var ans = nums[0]
    for (i in 1 until nums.size) {
      val ff = f
      val gg = g
      f = max(nums[i].toDouble(), max((ff * nums[i]).toDouble(), (gg * nums[i]).toDouble()))
        .toInt()
      g = min(nums[i].toDouble(), min((ff * nums[i]).toDouble(), (gg * nums[i]).toDouble()))
        .toInt()
      ans = max(ans.toDouble(), f.toDouble()).toInt()
    }
    return ans
  }
}
