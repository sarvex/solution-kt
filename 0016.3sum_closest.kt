import java.util.*
import kotlin.math.abs

internal class Solution {
  fun threeSumClosest(nums: IntArray, target: Int): Int {
    Arrays.sort(nums)
    var ans = 1 shl 30
    val n = nums.size
    for (i in 0 until n) {
      var j = i + 1
      var k = n - 1
      while (j < k) {
        val t = nums[i] + nums[j] + nums[k]
        if (t == target) {
          return t
        }
        if (abs((t - target).toDouble()) < abs((ans - target).toDouble())) {
          ans = t
        }
        if (t > target) {
          --k
        } else {
          ++j
        }
      }
    }
    return ans
  }
}
