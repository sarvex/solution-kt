import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maximumTop(nums: IntArray, k: Int): Int {
    if (k == 0) {
      return nums[0]
    }
    val n = nums.size
    if (n == 1) {
      return if (k % 2 == 1) {
        -1
      } else nums[0]
    }
    var ans = -1
    for (i in 0 until min((k - 1).toDouble(), n.toDouble()).toInt()) {
      ans = max(ans.toDouble(), nums[i].toDouble()).toInt()
    }
    if (k < n) {
      ans = max(ans.toDouble(), nums[k].toDouble()).toInt()
    }
    return ans
  }
}
