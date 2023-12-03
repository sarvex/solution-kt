import kotlin.math.max
import kotlin.math.min

class Solution {
  fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var ans: Long = 0
    var j1 = -1
    var j2 = -1
    var k = -1
    for (i in nums.indices) {
      if (nums[i] < minK || nums[i] > maxK) {
        k = i
      }
      if (nums[i] == minK) {
        j1 = i
      }
      if (nums[i] == maxK) {
        j2 = i
      }
      (ans += max(0.0, (min(j1.toDouble(), j2.toDouble()) - k).toDouble())).toLong()
    }
    return ans
  }
}
