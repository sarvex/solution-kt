import kotlin.math.min

class Solution {
  fun findValueOfPartition(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 1 shl 30
    for (i in 1 until nums.size) {
      ans = min(ans.toDouble(), (nums[i] - nums[i - 1]).toDouble()).toInt()
    }
    return ans
  }
}
