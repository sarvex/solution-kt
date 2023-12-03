import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun smallestRangeII(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    val n = nums.size
    var ans = nums[n - 1] - nums[0]
    for (i in 1 until n) {
      val mi = min((nums[0] + k).toDouble(), (nums[i] - k).toDouble()).toInt()
      val mx = max((nums[i - 1] + k).toDouble(), (nums[n - 1] - k).toDouble()).toInt()
      ans = min(ans.toDouble(), (mx - mi).toDouble()).toInt()
    }
    return ans
  }
}
